[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/OceanBBBBbb/ocean-code-generator) 

<h1 style="text-align: center" color="gray">ocean-code-generator 前后端代码自动生成器</h1>

#### 项目简介
ocean-code-generator采用(适用):
<img src="https://img.shields.io/badge/java-JDK1.8-green"/>
<img src="https://img.shields.io/badge/springboot-2.2.1-green"/>
<img src="https://img.shields.io/badge/mysql-orange"/>
<img src="https://img.shields.io/badge/jpa-orange"/>
<img src="https://img.shields.io/badge/vue-2.5.17-blueviolet"/>,并使用```maven```构建。
</br>
  支持自动生成一个业务逻辑增删改查的后端```controller```、```service```、```dao```的代码,
</br>  前端列表查询和单条数据的增删改查的```vue```代码。
</br>
这里是后端代码，前端在https://github.com/OceanBBBBbb/ocean-code-generator-fe。
</br>
如果你不会前端，也可以通过swagger实现整个流程！

#### 项目结构
- apply 系统应用模块（系统启动入口）
	- config 配置类信息
	- app 系统应用的业务模块(我在里面自动生成了一个test应用，对应了它的增删改查业务)
	- resources 静态资源
	   - config properties配置
	   - template 模板文件，其中admin是后端代码模板，front是前端，auto-vue是临时放自动生成的前端代码
	- testfiles  放的是test测试生成的建表语句和其他
	- 其他配置
	
- common 公共模块
    - exception 项目统一异常的处理
    - mapper mapstruct的通用mapper
    - swagger2 接口文档配置
    - utils 系统通用工具类
    
- generator 系统代码生成模块
    - 一个单独整套的代码生成实现
 
#### 使用说明
######  1.配置生成器
   项目启动时，jpa将会在所连库自动创建```ocean_gen_config```表，这是代码生成配置表。
需要先配置这个表的信息。注意这里的前端文件生成路径是绝对路径。
<img src="https://github.com/OceanBBBBbb/ocean-code-generator/blob/master/apply/src/main/resources/testfiles/oceang1.png"/>
   
######  2.选择生成参数
   然后自定义生成参数，哪些展示，展示为什么名，哪些需要支持精确或模糊查询等等。
<img src="https://github.com/OceanBBBBbb/ocean-code-generator/blob/master/apply/src/main/resources/testfiles/og2.png"/>
   
######  3.代码生成
   请求生成代码接口，生成代码。


#### 使用建议
###### 新项目
    当新建一个项目时，可以直接使用整个工程，再在apply里添加你的业务逻辑，实现快速开发。
    
###### 只引入自动生成
      当只要引入自动生成时，将generator模块加入到你的项目子模块，将apply下的模版文件
    引入到你的工程里，将common中用到的工具类，加入到你的工程中并供generator调用。
      这样就实现了将你的工程引入自动代码生成。可以修改模板ftl文件，自定义生成。
     
###### 演示接口调用步骤和内容
1，/api/genConfig，查看生成器配置；</br>
2，/api/genConfig，配置生成器；</br>
3，/api/generator/tables，查询数据库表；</br>
4，/api/generator/columns，查表字段信息；</br>
5，/api/generator，根据表名和字段配置生成代码。</br>

#### 感谢
需要特别感谢eladmin项目，本生成器，很多内容抽离自该项目。</br>
eladmin是一个非常强大的管理平台开源系统，项目地址:https://github.com/elunez/eladmin
