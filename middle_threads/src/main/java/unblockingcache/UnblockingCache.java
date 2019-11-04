package unblockingcache;

import java.util.concurrent.ConcurrentHashMap;

public class UnblockingCache {
    private ConcurrentHashMap<Integer, Base> cache;

    public UnblockingCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public void add(Base base) {
        cache.putIfAbsent(base.getId(), base);
    }

    public void update(Base base) {
        final int getId = base.getId();
        final int getVersion = base.getVesion();
        cache.computeIfPresent(getId, (idFuc, baseFunc) -> {
            if (getVersion != baseFunc.getVesion()) {
                throw new OptimisticException("OptimisticException");
            }
            return new Base(getId, getVersion + 1 );
        });
    }

    public void delete(Base base) {
        cache.remove(base.getId());
    }

    private void runException() {
        throw new OptimisticException("OptimisticException");
    }
}
