const fs = require('fs');
const path = require('path');
const https = require('https');

async function get(route) {
  return await fetch(`${api_base}/${route}`, { headers });
}

function compare_date(str_a, str_b) {
  return new Date(str_a) - new Date(str_b);
}

/**
 * @param {string} name
 * @param {string} mc_version
 */
async function get_project_latest_version(name, mc_version) {
  const query = new URLSearchParams({ game_versions: `["${mc_version}"]`, loaders: '["fabric"]' });
  const res = await get(`project/${name}/version?${query}`, { headers });

  if (!res.ok) {
    console.error(`failed to fetch versions for mod \`${name}\`:`, `${res.status} ${res.statusText}`);
  }

  /**
   * @type {{ version_number: string, date_published: string, files: { primary: boolean, filename: string, url: string }[]}[]}
   * */
  const versions = await res.json();

  return versions.sort((a, b) => compare_date(b.date_published, a.date_published))[0];
}

/**
 * @param {string} url
 * @param {string} file_path
 * @param {WriteStream} stream
 */
function download_file(url, file_path, stream = null) {
  return new Promise((resolve, reject) => {
    const file = stream ? stream : fs.createWriteStream(file_path);

    const request = https.get(url, { headers }, response => {
      // Handle redirect
      if (response.statusCode >= 300 && response.statusCode < 400 && response.headers.location) {
        download_file(response.headers.location, file_path, file).then(resolve).catch(reject);

        return;
      }

      response.pipe(file).on('finish', () => file.close(resolve));
    });

    const e = err => fs.unlink(file_path, () => reject(err));

    request.on('error', e);
    file.on('error', e);
  });
}

/**
 * @param {{filename: string, url: string}} file
 */
async function download_version_file(file) {
  const output_path = path.join(output_dir, file.filename);

  if (fs.existsSync(output_path)) {
    console.info('skipping existing mod:', `\`${file.filename}\``);
    return;
  }

  console.info('downloading', `\`${file.filename}\``, 'from', `\`${file.url}\``);

  try {
    await download_file(file.url, output_path);

    console.info('downloaded', `\`${file.filename}\``, 'to', `\`${output_path}\``);
  } catch (err) {
    console.error('download failed:', err);
  }
}

async function download_mod(name, mc_version) {
  let latest_version = await get_project_latest_version(name, mc_version);

  console.info('got', `\`${name}\``, 'version', `\`${latest_version.version_number}\``);

  const primary_file = latest_version.files.find(x => x.primary);

  if (!primary_file) {
    console.error("couldn't find primary version for", `\`${name}\``);
    return;
  }

  await download_version_file(primary_file);
}

/*
 * config
 */

const output_dir = './run/mods/';

const api_base = 'https://api.modrinth.com/v2';
const headers = {
  'User-Agent': 'fooooooooooooooo/upc',
};

const mods = ['megane', 'wthit', 'badpackets', 'cloth-config', 'architectury-api', 'modern-industrialization', 'rei'];
const mc_version = '1.18.2';

const exceptions = [
  {
    filename: 'TechReborn-5.2.1.jar',
    url: 'https://github.com/TechReborn/TechReborn/releases/download/5.2.1/TechReborn-5.2.1.jar',
  },
];

async function run() {
  for (const mod of mods) {
    await download_mod(mod, mc_version);
  }

  for (const exception of exceptions) {
    await download_version_file(exception);
  }

  process.exit(0);
}

run().then();
