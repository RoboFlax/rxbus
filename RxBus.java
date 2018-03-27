import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {
    
    @Getter
    private static final PublishSubject<Object> publisher = PublishSubject.create();
    
    
    public static <T> Observable<T> toObservable( Class<T> eventType ) {
        return getPublisher().ofType( eventType );
    }
    
    public static void publish( Object event ) {
        getPublisher().onNext( event );
    }
    
    public static <T> Disposable subscribe( Class<T> eventType, Consumer<T> handler ) {
        return toObservable( eventType ).subscribe( handler );
    }
}
