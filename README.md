[//]: # ([![]&#40;https://img.shields.io/github/license/mynxg/MultiSourceVideoDownload?color=4D7A97&logo=apache&#41;]&#40;https://github.com/me-shaon/GLWTPL/blob/master/LICENSE&#41;  )
[![](https://img.shields.io/github/stars/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/stargazers)
[![](https://img.shields.io/github/issues/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/issues)
[![](https://img.shields.io/github/issues-closed/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/issues?q=is%3Aissue+is%3Aclosed)
[![](https://img.shields.io/github/issues-pr/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/pulls)
[![](https://img.shields.io/github/issues-pr-closed/mynxg/MultiSourceVideoDownload)](https://github.com/mynxg/MultiSourceVideoDownload/pulls?q=is%3Apr+is%3Aclosed)

[简体中文](README.md) | [English](./docs/README-EN.md)
## 视频下载与解析 API
> 该 API 提供视频下载和解析服务，目前支持 Bilibili 和 YouTube。您可以通过此 API 下载视频、解析视频的元数据、并检查指定视频链接是否受支持。

## 功能特点
- 视频下载：目前支持从 Bilibili 和 YouTube 下载视频。
- 视频解析：提取视频的元数据，如标题、描述、封面url、视频url等信息。
- 格式选择：支持MP4格式。

## 支持平台
- [√] Bilibili
- [√] YouTube

## 使用说明
1.克隆仓库：
```bash
git clone git@github.com:mynxg/MultiSourceVideoDownload.git
cd MultiSourceVideoDownload
```

2.使用 IntelliJ IDEA 打开项目、使用 Maven 拉取依赖包并运行项目

2.1. **打开项目**：在 IntelliJ IDEA 中，依次点击 **File > Open...**，选择项目目录并打开项目。

2.2. **拉取依赖包**：项目打开后，进入 **Maven** 工具窗口（通常位于右侧），然后点击 **Reload All Maven Projects** 按钮（圆形箭头图标）以自动下载 `pom.xml` 文件中指定的所有依赖包。

2.3. **运行项目**：依赖包加载完成后，找到主应用程序类（通常包含 `main` 方法的类）。右键点击该类，选择 **Run 'MainClass'**（将 `MainClass` 替换为实际的类名），即可在 IntelliJ IDEA 中启动项目。

现在项目应已启动，并可按项目配置中的说明进行访问，默认运行在 http://localhost:8082。


## API 接口文档
1. 视频url解析
> 提供从支持的平台下载视频的功能。

接口地址：http://localhost:8082/api/v1/video/parser_url

请求方式：GET

参数说明：

| 参数名 | 是否必须 | 类型 | 描述 |
|--------|----------|---------|---------|
| url | 是 | string | 视频url |

请求示例：
```bash
curl -X GET "http://localhost:8082/api/v1/video/parser_url?url=https://www.bilibili.com/video/BV1DnUKYYEkj/?vd_source=83e20cd531608ce070908ea29997e648"
```

返回参数说明：

| 参数名      | 类型    | 描述           |
|-------------|---------|----------------|
| `code`      | `int`   | 状态码         |
| `data`      | `object`| 数据           |
| `message`   | `string`| 提示信息       |
| `data.cover`| `string`| 视频封面       |
| `data.title`| `string`| 视频标题       |
| `data.aid`  | `int`   | 视频 ID        |
| `data.url`  | `string`| 视频下载地址   |
| `data.cid`  | `int`   | 视频 CID       |
| `data.desc` | `string`| 视频描述       |

返回结果示例：
```json
{
    "code": 200,
    "data": {
        "cover": "http://i1.hdslb.com/bfs/archive/a782c8f7615c4e7e16dfaa6704db0b2bf6a3b30b.jpg",
        "title": "独家专访李子柒：归来依旧热爱",
        "aid": 113474277477413,
        "url": "https://cn-sccd-ct-01-21.bilivideo.com/upgcxcode/67/37/26738493767/26738493767-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1732038394&gen=playurlv2&os=bcache&oi=2101789121&trid=0000122cfe1b2eec4c9f87e3a7fa7cc5032dh&mid=0&platform=html5&og=cos&upsig=0992a520a677719134175aa44a0fd18c&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=62621&bvc=vod&nettype=0&f=h_0_0&bw=43101&logo=80000000",
        "cid": 26738493767,
        "desc": "李子柒，文化类视频创作者。她以制作精美的视频为载体，将中国乡村田园般的生活和中国传统文化的魅力传向海内外。三年后，她带着对美好生活的追求和对非遗文化的热爱，创作出新的作品，回归大众视野。\n\n对于过去的三年，有哪些感悟？\n对于非遗传承，有什么新的想法？\n对于未来的规划，她的设想又是什么？\n......\n\n李子柒独家专访，让我们听听她的回答。"
    },
    "message": "success"
}
```

## 注意事项
> 当前支持平台：该 API 目前仅支持 Bilibili 和 YouTube 视频的解析和下载功能。
>
> 依赖工具下载：拉取代码后需手动下载视频解析工具 yt-dlp.exe 和 yt-dlp_linux，以确保解析功能正常运行。
>
> yt-dlp 下载步骤
> 
> 前往 [yt-dlp](https://github.com/yt-dlp/yt-dlp/releases) 官方发布页 下载对应的 yt-dlp.exe（适用于 Windows）和 yt-dlp_linux（适用于 Linux）文件。
>
> 将下载的 yt-dlp.exe 和 yt-dlp_linux 文件放置于项目resources的 ytdown 目录下。
>
> 快捷下载：可以直接下载打包好的工具文件：[ytdown.zip](https://nxg.lanzoul.com/isYfD2fs763c)
>
> yt-dlp 版本：2024.11.18

## 贡献
欢迎贡献代码！请提交 Pull Request 或报告问题。

## 许可证
此项目使用 [GLWTPL](https://github.com/me-shaon/GLWTPL/blob/master/LICENSE) 许可证。

## Star History

[![Star History Chart](https://api.star-history.com/svg?repos=mynxg/MultiSourceVideoDownload&type=Date)](https://star-history.com/#mynxg/MultiSourceVideoDownload&Date)
