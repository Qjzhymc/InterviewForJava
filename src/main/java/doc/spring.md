1. 谈谈你对spring ioc的理解
答：ioc是控制反转的意思，是一种设计思想，就是将原本在程序中手动创建对象的控制权交给spring框架来管理，比如对象的创建管理交给ioc容器处理，
   比如在service中一个类可以引用很多其他类，如果我们需要实例化这个service对象，需要每次直到这个service所有底层类的构造函数，如果利用ioc的话，
   只需要配置好，在需要的地方引用就行了，可以增加项目的维护性。
   主要是通过Di依赖注入来实现的，可以通过@Autowaired，@resourse注解和populateBean方法来完成属性的注入。
   spring是一个存储对象的容器，使用map结构存储对象，在spring中存储对象的时候一般有三级缓存，singletonObjects存放完整对象，
   earlySingletonObjects存放半成品对象，singletonFactory用来存放lambda表达式和对象名称的映射，整个bean的生命周期，从创建到使用到销毁，
   各个环节都是由容器来帮我们控制的。

对aop的理解？
答：aop是面向切面编程的意思，会把哪些与业务无关的，为业务模块共同调用的逻辑封装起来，减少系统的重复代码，

2. spring bean的生命周期
主要分为实例化，属性赋值，初始化，销毁这几个阶段
初始化的话会设置相关依赖，有一些前置处理，后置处理，以及会执行自定义的init方法，
销毁阶段的话会注册相关的回调接口，销毁的时候也会执行自定义的销毁方法。
答：实例化bean对象-设置对象属性-检查Aware相关接口并设置相关依赖-进行beanPostProcessor前置处理-检查是否是initializingBean决定是否调用afterPropertiesSet方法----
检查是否配置有自定义的init-method----进行beanPostProcessor后置处理----注册必要的Destruction相关回调接口----使用中----销毁时判断是否实现DisposableBean接口----调用自定义的destory方法

spring boot的自动装配原理:
答案： 什么是自动装配：springboot在启动的时候会扫描外部jar包中的spring.factories文件，会讲文件中配置的类型信息加载到spring容器中。所以如果需要使用第三方依赖的话，可以直接引入一个starter，
就可以通过少量的注解和配置使用第三方组件提供的功能了。 
自动装配原理：首先springboot的核心注解是springBootApplication，springBootApplication这个注解可以看作是configuration，EnableAutoConfiguration，还有ComponentScan这三个注解的集合，
其中EnableAutoConfiguration这个注解会启用spring自动装配机制，自动装配核心功能是通过AutoConfigutationImportSelector类实现的，在AutoConfigurationImportSelector类中会加载自动装配类，
这个类有一个selectImports方法，这个方法主要用于获取所有符合条件的类的全限定名，将这些类加载到ioc容器中。

3. BeanFactory和FactoryBean
答：BeanFactory是一个工厂类，是ioc容器，负责生产和管理bean的一个工厂，是ioc容器的一个核心接口，负责实例化配置程序中的对象，建立这些对象的依赖。
FactoryBean是一个工厂类接口，用户可以实现这个接口定制实例化bean的逻辑。

4. spring中用到哪些设计模式

5. 谈谈你对循环依赖的理解（spring如何解决循环依赖）？
答：不用构造器注入用setter注入

7. spring aop的底层实现原理
代理模式

8. @autowired是按类型还是名称注入的？
默认是byType，但如果有多个实现类的话也会按名称，通过@Qualify(value="类名")来指定

9. spring依赖注入bean的三种方式？
属性注入：直接在成员变量上加@autowired注解
构造器注入：优点是可以用final修饰，如果有循环依赖的话，spring启动的话会报错；缺点是如果需要注入很多对象的话，构造函数会很臃肿。
setter方法注入：
使用的话如果属性是必须的话，可以用构造器注入；如果可选的属性，通过setter方法注入。

springboot的如何加载流程，加载了哪些东西？

spring中的bean是不是线程安全的

spring @RestController和@Controller的区别
答：RestController是Controller和ResponseBody的合集，会将函数的返回值直接填入http响应体中，

spring @Autowire和@Resource的区别？注入bean的注解有哪些？
答：@Autowired（Spring提供的注解，默认按类型匹配，可以用@Qualifier指定名称）， @Resource（JDK提供的注解，默认按名称匹配）

spring支持事务的两种方式？
答：编程式事务和声明式事务，编程式事务的话是通过transactionTemplate或transactionManager来手动管理事务；
声明式事务的话是通过在方法上加Transactional注解表示这个方式是一个事务执行。

spring配置方式？
答：基于Xml文件
基于注解
基于java类的配置方式，（@Comfiguration + @Bean）

spring @Cache的作用？
答：@Cache注解是放在方法上，表示调用这个方法的时候会把参数和返回值作为键值对存入缓存中。

spring cloud？
spring cloud的组件？
1、springcloud eurake：各个微服务启动时将自己注册到eurake server上
2、springcloud ribbon：各个服务相互调用到时候，通过ribbon进行客户端到负载均衡，从多个实例中根据策略选择一台进行请求
3、springcloud feign：基于动态代理机制，根据注解和参数拼接url，选择具体到服务实例发出请求
4、springcloud hystrix
5、springcloud zuul：外部请求统一通过网关进入

springboot的定时器？
答：在入口类@EnableScheduling注解表示开启定时，在要定时的方法上加@Scheduled注解