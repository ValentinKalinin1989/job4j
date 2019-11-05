package unblockingcache;

import java.util.concurrent.ConcurrentHashMap;

public class UnblockingCache {
    private final ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    public void add(Base base) {
        cache.putIfAbsent(base.getId(), base);
    }

    public void update(Base base) throws  OptimisticException {
        cache.computeIfPresent(base.getId(), (k, v) -> {
            if (v.getVersion() != base.getVersion()) {
                throw new OptimisticException("OptimisticException");
            }
            base.setVersion(base.getVersion() + 1);
            return base;
        });
    }

    public void delete(Base base) {
        cache.remove(base.getId());
    }
}
