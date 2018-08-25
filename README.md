# BrightManager 1.0

## 介绍
基于开源guns,加入PageData支持。

###项目特点
####1. PageData
1.PageData继承于HashMap，实现Map接口，经过重新和改造，使PageData适合作为数据查询结果和数据封装传输。
2.在开发接口时，可以省去dto，从mybatis查询出结果集直接指定为PageData，则得到该实体类属性和值对应已经put进去的PageData，在需要的时候不依赖于实体类而加入新的属性作为一个对象结果返回页面。查询多个结果得到该实体类属性映射的PageData的List，对List进行循环可以进行进一步操作。
3.使用PageData，根据个人情况，可以不需要实体类。