# RxBus: A simple eventbus using https://github.com/ReactiveX/RxJava

### Example use:

```java

RxBus.listen( String.class )
     .buffer( 2 )
     .subscribe( System.out::println );
        
RxBus.publish( "Object one" );
RxBus.publish( "Object two" );

RxBus.publish( "Object three" );
RxBus.publish( "Object four" );

RxBus.publish( "Object five ;(" );
```
