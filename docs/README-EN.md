[//]: # ([![]&#40;https://img.shields.io/github/license/mynxg/MultiSourceVideoDownload?color=4D7A97&logo=apache&#41;]&#40;https://github.com/me-shaon/GLWTPL/blob/master/LICENSE&#41;  )
[![](https://img.shields.io/github/stars/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/stargazers)
[![](https://img.shields.io/github/issues/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/issues)
[![](https://img.shields.io/github/issues-closed/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/issues?q=is%3Aissue+is%3Aclosed)
[![](https://img.shields.io/github/issues-pr/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/pulls)
[![](https://img.shields.io/github/issues-pr-closed/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/pulls?q=is%3Apr+is%3Aclosed)


[简体中文](README.md) | [English](./docs/README-EN.md)

# Video Download & Parsing API

> This API provides video download and parsing services, currently supporting Bilibili and YouTube. You can use this API to download videos, parse video metadata, and check if a specific video URL is supported.

## Features

- **Video Download**: Currently supports downloading videos from Bilibili and YouTube.
- **Video Parsing**: Extracts video metadata, such as title, description, cover URL, and video URL.
- **Format Selection**: Supports downloading in MP4 format.

## Supported Platforms

- [√] Bilibili
- [√] YouTube

## Usage Instructions

1. **Clone the Repository**:
   ```bash
   git clone git@github.com:mynxg/MultiSourceVideoDownload.git
   ```

2. Open the Project with IntelliJ IDEA, Pull Dependencies with Maven, and Run the Project

2.1. **Open the Project**: In IntelliJ IDEA, go to **File > Open...** and select the project directory to open it.

2.2. **Pull Dependencies**: Once the project is open, navigate to the **Maven** tool window (usually on the right side). Then, click on the **Reload All Maven Projects** button (circular arrow icon) to automatically download all dependencies specified in the `pom.xml` file.

2.3. **Run the Project**: After dependencies are loaded, locate the main application class (usually containing a `main` method). Right-click on it and select **Run 'MainClass'** (replacing `MainClass` with the actual class name). This will start the project within IntelliJ IDEA. 

Your project should now be running and accessible as specified in the project configuration.
After starting, the server will be available at `http://localhost:8082`.

## API Documentation

### 1. Video URL Parsing

Provides functionality to download videos from supported platforms.


**URL**: `http://localhost:8082/api/v1/video/parser_url`

**Request Method**: GET

**Parameters**:

| Parameter | Required | Type   | Description       |
|-----------|----------|--------|-------------------|
| `url`     | Yes      | string | Video URL         |

**Request Example**:
```bash
curl -X GET "http://localhost:8082/api/v1/video/parser_url?url=https://www.bilibili.com/video/BV1DnUKYYEkj/?vd_source=83e20cd531608ce070908ea29997e648"
```

**Response Parameters**:

| Parameter       | Type     | Description         |
|-----------------|----------|---------------------|
| `code`          | `int`    | Status code         |
| `data`          | `object` | Data object         |
| `message`       | `string` | Status message      |
| `data.cover`    | `string` | Video cover URL     |
| `data.title`    | `string` | Video title         |
| `data.aid`      | `int`    | Video ID            |
| `data.url`      | `string` | Video download URL  |
| `data.cid`      | `int`    | Video CID           |
| `data.desc`     | `string` | Video description   |

**Response Example**:
```json
{
    "code": 200,
    "data": {
        "cover": "http://i1.hdslb.com/bfs/archive/a782c8f7615c4e7e16dfaa6704db0b2bf6a3b30b.jpg",
        "title": "Exclusive Interview with Li Ziqi",
        "aid": 113474277477413,
        "url": "https://cn-sccd-ct-01-21.bilivideo.com/upgcxcode/67/37/26738493767/26738493767-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1732038394&gen=playurlv2&os=bcache&oi=2101789121&trid=0000122cfe1b2eec4c9f87e3a7fa7cc5032dh&mid=0&platform=html5&og=cos&upsig=0992a520a677719134175aa44a0fd18c&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=62621&bvc=vod&nettype=0&f=h_0_0&bw=43101&logo=80000000",
        "cid": 26738493767,
        "desc": "Li Ziqi, a creator of cultural videos, brings the beauty of rural Chinese life and traditional culture to audiences worldwide through her carefully crafted videos. After three years, she returns with new creations inspired by her passion for a beautiful life and traditional crafts..."
    },
    "message": "success"
}
```

## Important Notes

- **Supported Platforms**: The API currently supports video parsing and download for Bilibili and YouTube only.
  
- **Dependency Download**: After cloning the code, download `yt-dlp.exe` and `yt-dlp_linux` to enable parsing functionality.

### yt-dlp Download Instructions

- Visit the official [yt-dlp release page](https://github.com/yt-dlp/yt-dlp/releases) to download `yt-dlp.exe` (for Windows) and `yt-dlp_linux` (for Linux).

- Place both `yt-dlp.exe` and `yt-dlp_linux` in the `resources/ytdown` directory within the project.

> **Quick Download**: You can also download the tools as a package: [ytdown.zip](https://nxg.lanzoul.com/isYfD2fs763c)

- **yt-dlp Version**: 2024.11.18

## Contribution

Contributions are welcome! Please submit a Pull Request or report any issues.

## License

This project is licensed under [GLWTPL](https://github.com/me-shaon/GLWTPL/blob/master/LICENSE).

## Star History

[![Star History Chart](https://api.star-history.com/svg?repos=mynxg/MultiSourceVideoDownload&type=Date)](https://star-history.com/#mynxg/MultiSourceVideoDownload&Date)
