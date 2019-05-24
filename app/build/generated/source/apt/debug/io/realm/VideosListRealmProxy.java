package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideosListRealmProxy extends com.schandorf.elmenorah.POJO.VideosList
    implements RealmObjectProxy, VideosListRealmProxyInterface {

    static final class VideosListColumnInfo extends ColumnInfo
        implements Cloneable {

        public long descriptionIndex;
        public long idIndex;
        public long titleIndex;
        public long videoIdIndex;
        public long videoCategoryIndex;

        VideosListColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.descriptionIndex = getValidColumnIndex(path, table, "VideosList", "description");
            indicesMap.put("description", this.descriptionIndex);
            this.idIndex = getValidColumnIndex(path, table, "VideosList", "id");
            indicesMap.put("id", this.idIndex);
            this.titleIndex = getValidColumnIndex(path, table, "VideosList", "title");
            indicesMap.put("title", this.titleIndex);
            this.videoIdIndex = getValidColumnIndex(path, table, "VideosList", "videoId");
            indicesMap.put("videoId", this.videoIdIndex);
            this.videoCategoryIndex = getValidColumnIndex(path, table, "VideosList", "videoCategory");
            indicesMap.put("videoCategory", this.videoCategoryIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final VideosListColumnInfo otherInfo = (VideosListColumnInfo) other;
            this.descriptionIndex = otherInfo.descriptionIndex;
            this.idIndex = otherInfo.idIndex;
            this.titleIndex = otherInfo.titleIndex;
            this.videoIdIndex = otherInfo.videoIdIndex;
            this.videoCategoryIndex = otherInfo.videoCategoryIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final VideosListColumnInfo clone() {
            return (VideosListColumnInfo) super.clone();
        }

    }
    private VideosListColumnInfo columnInfo;
    private ProxyState<com.schandorf.elmenorah.POJO.VideosList> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("description");
        fieldNames.add("id");
        fieldNames.add("title");
        fieldNames.add("videoId");
        fieldNames.add("videoCategory");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    VideosListRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (VideosListColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.schandorf.elmenorah.POJO.VideosList>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$videoId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.videoIdIndex);
    }

    @Override
    public void realmSet$videoId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.videoIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.videoIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$videoCategory() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.videoCategoryIndex);
    }

    @Override
    public void realmSet$videoCategory(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoCategoryIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.videoCategoryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoCategoryIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.videoCategoryIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("VideosList")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("VideosList");
            realmObjectSchema.add("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("videoId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("videoCategory", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("VideosList");
    }

    public static VideosListColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_VideosList")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'VideosList' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_VideosList");
        final long columnCount = table.getColumnCount();
        if (columnCount != 5) {
            if (columnCount < 5) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final VideosListColumnInfo columnInfo = new VideosListColumnInfo(sharedRealm.getPath(), table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("description")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'description' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("description") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'description' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.descriptionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'description' is required. Either set @Required to field 'description' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' is required. Either set @Required to field 'id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("title")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("title") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'title' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.titleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("videoId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'videoId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("videoId") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'videoId' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.videoIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'videoId' is required. Either set @Required to field 'videoId' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("videoCategory")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'videoCategory' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("videoCategory") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'videoCategory' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.videoCategoryIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'videoCategory' is required. Either set @Required to field 'videoCategory' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_VideosList";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.schandorf.elmenorah.POJO.VideosList createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.schandorf.elmenorah.POJO.VideosList obj = realm.createObjectInternal(com.schandorf.elmenorah.POJO.VideosList.class, true, excludeFields);
        if (json.has("description")) {
            if (json.isNull("description")) {
                ((VideosListRealmProxyInterface) obj).realmSet$description(null);
            } else {
                ((VideosListRealmProxyInterface) obj).realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((VideosListRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((VideosListRealmProxyInterface) obj).realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((VideosListRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((VideosListRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("videoId")) {
            if (json.isNull("videoId")) {
                ((VideosListRealmProxyInterface) obj).realmSet$videoId(null);
            } else {
                ((VideosListRealmProxyInterface) obj).realmSet$videoId((String) json.getString("videoId"));
            }
        }
        if (json.has("videoCategory")) {
            if (json.isNull("videoCategory")) {
                ((VideosListRealmProxyInterface) obj).realmSet$videoCategory(null);
            } else {
                ((VideosListRealmProxyInterface) obj).realmSet$videoCategory((String) json.getString("videoCategory"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.schandorf.elmenorah.POJO.VideosList createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.schandorf.elmenorah.POJO.VideosList obj = new com.schandorf.elmenorah.POJO.VideosList();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("description")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VideosListRealmProxyInterface) obj).realmSet$description(null);
                } else {
                    ((VideosListRealmProxyInterface) obj).realmSet$description((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VideosListRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((VideosListRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VideosListRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((VideosListRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("videoId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VideosListRealmProxyInterface) obj).realmSet$videoId(null);
                } else {
                    ((VideosListRealmProxyInterface) obj).realmSet$videoId((String) reader.nextString());
                }
            } else if (name.equals("videoCategory")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((VideosListRealmProxyInterface) obj).realmSet$videoCategory(null);
                } else {
                    ((VideosListRealmProxyInterface) obj).realmSet$videoCategory((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.schandorf.elmenorah.POJO.VideosList copyOrUpdate(Realm realm, com.schandorf.elmenorah.POJO.VideosList object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.schandorf.elmenorah.POJO.VideosList) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.schandorf.elmenorah.POJO.VideosList copy(Realm realm, com.schandorf.elmenorah.POJO.VideosList newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.schandorf.elmenorah.POJO.VideosList) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.schandorf.elmenorah.POJO.VideosList realmObject = realm.createObjectInternal(com.schandorf.elmenorah.POJO.VideosList.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((VideosListRealmProxyInterface) realmObject).realmSet$description(((VideosListRealmProxyInterface) newObject).realmGet$description());
            ((VideosListRealmProxyInterface) realmObject).realmSet$id(((VideosListRealmProxyInterface) newObject).realmGet$id());
            ((VideosListRealmProxyInterface) realmObject).realmSet$title(((VideosListRealmProxyInterface) newObject).realmGet$title());
            ((VideosListRealmProxyInterface) realmObject).realmSet$videoId(((VideosListRealmProxyInterface) newObject).realmGet$videoId());
            ((VideosListRealmProxyInterface) realmObject).realmSet$videoCategory(((VideosListRealmProxyInterface) newObject).realmGet$videoCategory());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.schandorf.elmenorah.POJO.VideosList object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.VideosList.class);
        long tableNativePtr = table.getNativeTablePointer();
        VideosListColumnInfo columnInfo = (VideosListColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.VideosList.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$description = ((VideosListRealmProxyInterface)object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$id = ((VideosListRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$title = ((VideosListRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$videoId = ((VideosListRealmProxyInterface)object).realmGet$videoId();
        if (realmGet$videoId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoIdIndex, rowIndex, realmGet$videoId, false);
        }
        String realmGet$videoCategory = ((VideosListRealmProxyInterface)object).realmGet$videoCategory();
        if (realmGet$videoCategory != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoCategoryIndex, rowIndex, realmGet$videoCategory, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.VideosList.class);
        long tableNativePtr = table.getNativeTablePointer();
        VideosListColumnInfo columnInfo = (VideosListColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.VideosList.class);
        com.schandorf.elmenorah.POJO.VideosList object = null;
        while (objects.hasNext()) {
            object = (com.schandorf.elmenorah.POJO.VideosList) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$description = ((VideosListRealmProxyInterface)object).realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
                }
                String realmGet$id = ((VideosListRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                }
                String realmGet$title = ((VideosListRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$videoId = ((VideosListRealmProxyInterface)object).realmGet$videoId();
                if (realmGet$videoId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.videoIdIndex, rowIndex, realmGet$videoId, false);
                }
                String realmGet$videoCategory = ((VideosListRealmProxyInterface)object).realmGet$videoCategory();
                if (realmGet$videoCategory != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.videoCategoryIndex, rowIndex, realmGet$videoCategory, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.schandorf.elmenorah.POJO.VideosList object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.VideosList.class);
        long tableNativePtr = table.getNativeTablePointer();
        VideosListColumnInfo columnInfo = (VideosListColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.VideosList.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$description = ((VideosListRealmProxyInterface)object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$id = ((VideosListRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$title = ((VideosListRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$videoId = ((VideosListRealmProxyInterface)object).realmGet$videoId();
        if (realmGet$videoId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoIdIndex, rowIndex, realmGet$videoId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoIdIndex, rowIndex, false);
        }
        String realmGet$videoCategory = ((VideosListRealmProxyInterface)object).realmGet$videoCategory();
        if (realmGet$videoCategory != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoCategoryIndex, rowIndex, realmGet$videoCategory, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoCategoryIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.VideosList.class);
        long tableNativePtr = table.getNativeTablePointer();
        VideosListColumnInfo columnInfo = (VideosListColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.VideosList.class);
        com.schandorf.elmenorah.POJO.VideosList object = null;
        while (objects.hasNext()) {
            object = (com.schandorf.elmenorah.POJO.VideosList) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$description = ((VideosListRealmProxyInterface)object).realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
                }
                String realmGet$id = ((VideosListRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                String realmGet$title = ((VideosListRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$videoId = ((VideosListRealmProxyInterface)object).realmGet$videoId();
                if (realmGet$videoId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.videoIdIndex, rowIndex, realmGet$videoId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.videoIdIndex, rowIndex, false);
                }
                String realmGet$videoCategory = ((VideosListRealmProxyInterface)object).realmGet$videoCategory();
                if (realmGet$videoCategory != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.videoCategoryIndex, rowIndex, realmGet$videoCategory, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.videoCategoryIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.schandorf.elmenorah.POJO.VideosList createDetachedCopy(com.schandorf.elmenorah.POJO.VideosList realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.schandorf.elmenorah.POJO.VideosList unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.schandorf.elmenorah.POJO.VideosList)cachedObject.object;
            } else {
                unmanagedObject = (com.schandorf.elmenorah.POJO.VideosList)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.schandorf.elmenorah.POJO.VideosList();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((VideosListRealmProxyInterface) unmanagedObject).realmSet$description(((VideosListRealmProxyInterface) realmObject).realmGet$description());
        ((VideosListRealmProxyInterface) unmanagedObject).realmSet$id(((VideosListRealmProxyInterface) realmObject).realmGet$id());
        ((VideosListRealmProxyInterface) unmanagedObject).realmSet$title(((VideosListRealmProxyInterface) realmObject).realmGet$title());
        ((VideosListRealmProxyInterface) unmanagedObject).realmSet$videoId(((VideosListRealmProxyInterface) realmObject).realmGet$videoId());
        ((VideosListRealmProxyInterface) unmanagedObject).realmSet$videoCategory(((VideosListRealmProxyInterface) realmObject).realmGet$videoCategory());
        return unmanagedObject;
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideosListRealmProxy aVideosList = (VideosListRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aVideosList.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aVideosList.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aVideosList.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
