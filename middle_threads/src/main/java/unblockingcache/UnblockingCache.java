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
        final int originalVersio = base.getVersionBase();
        cache.computeIfPresent(base.getId(), (idFuc, baseFunc) -> {
            if(originalVersio != baseFunc.getVersionBase()) {
                runException();
            }
            return new Base(idFuc, baseFunc.getVersionBase() + 1);
        });
    }

    public void delete(Base base) {
        cache.remove(base.getId());
    }

    private void runException() {
        throw new OptimisticException("OptimisticException");
    }
}
