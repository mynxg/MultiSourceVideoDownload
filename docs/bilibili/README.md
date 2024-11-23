## bilibili_downloader

视频解析接口：
请求报文：
```
http://localhost:8082/api/v1/video/parser_url?url=https://www.bilibili.com/video/BV1DnUKYYEkj/?vd_source=83e20cd531608ce070908ea29997e648
```
> url 参数,视频url
> get请求
> 返回json数据

返回报文：
```
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


## 使用说明
- [bilibili-API-collect](https://github.com/SocialSisterYi/bilibili-API-collect)

