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
        int baseId = base.getId();
        Base etalonBase = cache.get(baseId);
        Base updateBase = new Base(etalonBase.getId(), etalonBase.getVesion() + 1);
        if (etalonBase.equals(cache.get(baseId))) {
            cache.computeIfPresent(baseId, (id, version) -> version = updateBase);
        } else {
            throw new OptimisticException("OptimisticException");
        }
    }

    public void delete(Base base) {
        cache.remove(base.getId());
    }
}
