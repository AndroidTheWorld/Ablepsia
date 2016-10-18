# Ablepsia
**Ablepsia** 是一个可以替代 startActivity() 的框架，并且支持 activity 之间跳转的拦截和重定向，重定向保存此次跳转的存活。

举个栗子：现在有两个 activity ，一个是 首页，一个是 用户详情，现在的业务规则是打开 用户详情 之前必须要求是已登陆状态。

so.原来的处理方式是你在打开 用户详情 之前判断是否已登陆，如果未登录就打开登录页面，好吧，你这么做我也没有意见。但是如果后续还增加了 订单列表、订单详情、...以及 N 个需要已登录才能打开的页面，那么你又要写 N 次判断。

对于上述栗子，Ablepsia 的处理姿势可谓是十分优雅，将 N 变为 1 次判断，自动重定向到登录页面，登录成功后自动跳转到 用户详情 页面。*.......目前 git 上的路由框架的实现方式，一旦你拦截此次跳转，此次跳转的生命就结束了，所以无法做到登录成功后自动跳转到 用户详情 页面*

#Use it#

```java
//项目的 build.gradle 添加如下
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

```
// 模块的 build.gradle 添加如下
dependencies {
	        compile 'com.github.Xiao187:Ablepsia:v1.0.2'
	}
```

[**Ablepsia - 详细使用姿势**][1]



[1]: https://github.com/Xiao187/Ablepsia
