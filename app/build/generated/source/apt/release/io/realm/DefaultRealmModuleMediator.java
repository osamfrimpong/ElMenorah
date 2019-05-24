package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.schandorf.elmenorah.POJO.VideosList.class);
        modelClasses.add(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        modelClasses.add(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            return io.realm.VideosListRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            return io.realm.LiteraturePOJORealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            return io.realm.AppRegistrationDataPOJORealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            return io.realm.VideosListRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            return io.realm.LiteraturePOJORealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            return io.realm.AppRegistrationDataPOJORealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            return io.realm.VideosListRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            return io.realm.LiteraturePOJORealmProxy.getFieldNames();
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            return io.realm.AppRegistrationDataPOJORealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            return io.realm.VideosListRealmProxy.getTableName();
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            return io.realm.LiteraturePOJORealmProxy.getTableName();
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            return io.realm.AppRegistrationDataPOJORealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
                return clazz.cast(new io.realm.VideosListRealmProxy());
            }
            if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
                return clazz.cast(new io.realm.LiteraturePOJORealmProxy());
            }
            if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
                return clazz.cast(new io.realm.AppRegistrationDataPOJORealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            return clazz.cast(io.realm.VideosListRealmProxy.copyOrUpdate(realm, (com.schandorf.elmenorah.POJO.VideosList) obj, update, cache));
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            return clazz.cast(io.realm.LiteraturePOJORealmProxy.copyOrUpdate(realm, (com.schandorf.elmenorah.POJO.LiteraturePOJO) obj, update, cache));
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            return clazz.cast(io.realm.AppRegistrationDataPOJORealmProxy.copyOrUpdate(realm, (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            io.realm.VideosListRealmProxy.insert(realm, (com.schandorf.elmenorah.POJO.VideosList) object, cache);
        } else if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            io.realm.LiteraturePOJORealmProxy.insert(realm, (com.schandorf.elmenorah.POJO.LiteraturePOJO) object, cache);
        } else if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            io.realm.AppRegistrationDataPOJORealmProxy.insert(realm, (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
                io.realm.VideosListRealmProxy.insert(realm, (com.schandorf.elmenorah.POJO.VideosList) object, cache);
            } else if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
                io.realm.LiteraturePOJORealmProxy.insert(realm, (com.schandorf.elmenorah.POJO.LiteraturePOJO) object, cache);
            } else if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
                io.realm.AppRegistrationDataPOJORealmProxy.insert(realm, (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
                    io.realm.VideosListRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
                    io.realm.LiteraturePOJORealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
                    io.realm.AppRegistrationDataPOJORealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            io.realm.VideosListRealmProxy.insertOrUpdate(realm, (com.schandorf.elmenorah.POJO.VideosList) obj, cache);
        } else if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            io.realm.LiteraturePOJORealmProxy.insertOrUpdate(realm, (com.schandorf.elmenorah.POJO.LiteraturePOJO) obj, cache);
        } else if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            io.realm.AppRegistrationDataPOJORealmProxy.insertOrUpdate(realm, (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
                io.realm.VideosListRealmProxy.insertOrUpdate(realm, (com.schandorf.elmenorah.POJO.VideosList) object, cache);
            } else if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
                io.realm.LiteraturePOJORealmProxy.insertOrUpdate(realm, (com.schandorf.elmenorah.POJO.LiteraturePOJO) object, cache);
            } else if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
                io.realm.AppRegistrationDataPOJORealmProxy.insertOrUpdate(realm, (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
                    io.realm.VideosListRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
                    io.realm.LiteraturePOJORealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
                    io.realm.AppRegistrationDataPOJORealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            return clazz.cast(io.realm.VideosListRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            return clazz.cast(io.realm.LiteraturePOJORealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            return clazz.cast(io.realm.AppRegistrationDataPOJORealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            return clazz.cast(io.realm.VideosListRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            return clazz.cast(io.realm.LiteraturePOJORealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            return clazz.cast(io.realm.AppRegistrationDataPOJORealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.schandorf.elmenorah.POJO.VideosList.class)) {
            return clazz.cast(io.realm.VideosListRealmProxy.createDetachedCopy((com.schandorf.elmenorah.POJO.VideosList) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.LiteraturePOJO.class)) {
            return clazz.cast(io.realm.LiteraturePOJORealmProxy.createDetachedCopy((com.schandorf.elmenorah.POJO.LiteraturePOJO) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class)) {
            return clazz.cast(io.realm.AppRegistrationDataPOJORealmProxy.createDetachedCopy((com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
