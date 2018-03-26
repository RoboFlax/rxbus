import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {
    
    private static RxBus instance;
    
    private final PublishSubject<Object> publisher = PublishSubject.create();
    
    private RxBus( ) {
        instance = this;
    }
    
    private static RxBus getInstance( ) {
        if ( instance == null ) instance = new RxBus();
        return instance;
    }
    
    public static void publish( Object event ) {
        getInstance().publisher.onNext( event );
    }
    
    public static <T> Observable<T> listen( Class<T> eventType ) {
        return getInstance().publisher.ofType( eventType );
    }
}
