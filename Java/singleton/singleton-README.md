| class file | is thread-safe | is locked | is lazy-load |
|    :---- : |         :----: |    :----: |        :----:|
| HungryStyleSingleton | true | false | false | 
| LazyStyleSingleton | false | false | true | 
| LazyStyleSingletonWithLock | true | true | true | 
| LazyStyleSingletonDoubleLock | true | true | true | 
| StaticInnerClassSingleton | true | false | true | 
| EnumSingleton | true | false | true | 
