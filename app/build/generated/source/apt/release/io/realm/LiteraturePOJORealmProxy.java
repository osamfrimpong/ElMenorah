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

public class LiteraturePOJORealmProxy extends com.schandorf.elmenorah.POJO.LiteraturePOJO
    implements RealmObjectProxy, LiteraturePOJORealmProxyInterface {

    static final class LiteraturePOJOColumnInfo extends ColumnInfo
        implements Cloneable {

        public long imageIndex;
        public long idIndex;
        public long titleIndex;
        public long categoryIndex;
        public long contentIndex;
        public long dateAddedIndex;

        LiteraturePOJOColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(6);
            this.imageIndex = getValidColumnIndex(path, table, "LiteraturePOJO", "image");
            indicesMap.put("image", this.imageIndex);
            this.idIndex = getValidColumnIndex(path, table, "LiteraturePOJO", "id");
            indicesMap.put("id", this.idIndex);
            this.titleIndex = getValidColumnIndex(path, table, "LiteraturePOJO", "title");
            indicesMap.put("title", this.titleIndex);
            this.categoryIndex = getValidColumnIndex(path, table, "LiteraturePOJO", "category");
            indicesMap.put("category", this.categoryIndex);
            this.contentIndex = getValidColumnIndex(path, table, "LiteraturePOJO", "content");
            indicesMap.put("content", this.contentIndex);
            this.dateAddedIndex = getValidColumnIndex(path, table, "LiteraturePOJO", "dateAdded");
            indicesMap.put("dateAdded", this.dateAddedIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final LiteraturePOJOColumnInfo otherInfo = (LiteraturePOJOColumnInfo) other;
            this.imageIndex = otherInfo.imageIndex;
            this.idIndex = otherInfo.idIndex;
            this.titleIndex = otherInfo.titleIndex;
            this.categoryIndex = otherInfo.categoryIndex;
            this.contentIndex = otherInfo.contentIndex;
            this.dateAddedIndex = otherInfo.dateAddedIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final LiteraturePOJOColumnInfo clone() {
            return (LiteraturePOJOColumnInfo) super.clone();
        }

    }
    private LiteraturePOJOColumnInfo columnInfo;
    private ProxyState<com.schandorf.elmenorah.POJO.LiteraturePOJO> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("image");
        fieldNames.add("id");
        fieldNames.add("title");
        fieldNames.add("category");
        fieldNames.add("content");
        fieldNames.add("dateAdded");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    LiteraturePOJORealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LiteraturePOJOColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.schandorf.elmenorah.POJO.LiteraturePOJO>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$image() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageIndex);
    }

    @Override
    public void realmSet$image(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageIndex, value);
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
    public String realmGet$category() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.categoryIndex);
    }

    @Override
    public void realmSet$category(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.categoryIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.categoryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.categoryIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.categoryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$content() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentIndex);
    }

    @Override
    public void realmSet$content(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$dateAdded() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateAddedIndex);
    }

    @Override
    public void realmSet$dateAdded(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateAddedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dateAddedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateAddedIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dateAddedIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("LiteraturePOJO")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("LiteraturePOJO");
            realmObjectSchema.add("image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("category", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("dateAdded", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("LiteraturePOJO");
    }

    public static LiteraturePOJOColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_LiteraturePOJO")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'LiteraturePOJO' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_LiteraturePOJO");
        final long columnCount = table.getColumnCount();
        if (columnCount != 6) {
            if (columnCount < 6) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final LiteraturePOJOColumnInfo columnInfo = new LiteraturePOJOColumnInfo(sharedRealm.getPath(), table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("image")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'image' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("image") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'image' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.imageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'image' is required. Either set @Required to field 'image' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("category")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'category' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("category") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'category' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.categoryIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'category' is required. Either set @Required to field 'category' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("content")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'content' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("content") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'content' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.contentIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'content' is required. Either set @Required to field 'content' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("dateAdded")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateAdded' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("dateAdded") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateAdded' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.dateAddedIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateAdded' is required. Either set @Required to field 'dateAdded' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_LiteraturePOJO";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.schandorf.elmenorah.POJO.LiteraturePOJO createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.schandorf.elmenorah.POJO.LiteraturePOJO obj = realm.createObjectInternal(com.schandorf.elmenorah.POJO.LiteraturePOJO.class, true, excludeFields);
        if (json.has("image")) {
            if (json.isNull("image")) {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$image(null);
            } else {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$image((String) json.getString("image"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("category")) {
            if (json.isNull("category")) {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$category(null);
            } else {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$category((String) json.getString("category"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$content(null);
            } else {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("dateAdded")) {
            if (json.isNull("dateAdded")) {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$dateAdded(null);
            } else {
                ((LiteraturePOJORealmProxyInterface) obj).realmSet$dateAdded((String) json.getString("dateAdded"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.schandorf.elmenorah.POJO.LiteraturePOJO createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.schandorf.elmenorah.POJO.LiteraturePOJO obj = new com.schandorf.elmenorah.POJO.LiteraturePOJO();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("image")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$image(null);
                } else {
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$image((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("category")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$category(null);
                } else {
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$category((String) reader.nextString());
                }
            } else if (name.equals("content")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$content(null);
                } else {
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$content((String) reader.nextString());
                }
            } else if (name.equals("dateAdded")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$dateAdded(null);
                } else {
                    ((LiteraturePOJORealmProxyInterface) obj).realmSet$dateAdded((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.schandorf.elmenorah.POJO.LiteraturePOJO copyOrUpdate(Realm realm, com.schandorf.elmenorah.POJO.LiteraturePOJO object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.schandorf.elmenorah.POJO.LiteraturePOJO) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.schandorf.elmenorah.POJO.LiteraturePOJO copy(Realm realm, com.schandorf.elmenorah.POJO.LiteraturePOJO newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.schandorf.elmenorah.POJO.LiteraturePOJO) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.schandorf.elmenorah.POJO.LiteraturePOJO realmObject = realm.createObjectInternal(com.schandorf.elmenorah.POJO.LiteraturePOJO.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((LiteraturePOJORealmProxyInterface) realmObject).realmSet$image(((LiteraturePOJORealmProxyInterface) newObject).realmGet$image());
            ((LiteraturePOJORealmProxyInterface) realmObject).realmSet$id(((LiteraturePOJORealmProxyInterface) newObject).realmGet$id());
            ((LiteraturePOJORealmProxyInterface) realmObject).realmSet$title(((LiteraturePOJORealmProxyInterface) newObject).realmGet$title());
            ((LiteraturePOJORealmProxyInterface) realmObject).realmSet$category(((LiteraturePOJORealmProxyInterface) newObject).realmGet$category());
            ((LiteraturePOJORealmProxyInterface) realmObject).realmSet$content(((LiteraturePOJORealmProxyInterface) newObject).realmGet$content());
            ((LiteraturePOJORealmProxyInterface) realmObject).realmSet$dateAdded(((LiteraturePOJORealmProxyInterface) newObject).realmGet$dateAdded());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.schandorf.elmenorah.POJO.LiteraturePOJO object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        long tableNativePtr = table.getNativeTablePointer();
        LiteraturePOJOColumnInfo columnInfo = (LiteraturePOJOColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$image = ((LiteraturePOJORealmProxyInterface)object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        }
        String realmGet$id = ((LiteraturePOJORealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$title = ((LiteraturePOJORealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$category = ((LiteraturePOJORealmProxyInterface)object).realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.categoryIndex, rowIndex, realmGet$category, false);
        }
        String realmGet$content = ((LiteraturePOJORealmProxyInterface)object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        String realmGet$dateAdded = ((LiteraturePOJORealmProxyInterface)object).realmGet$dateAdded();
        if (realmGet$dateAdded != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateAddedIndex, rowIndex, realmGet$dateAdded, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        long tableNativePtr = table.getNativeTablePointer();
        LiteraturePOJOColumnInfo columnInfo = (LiteraturePOJOColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        com.schandorf.elmenorah.POJO.LiteraturePOJO object = null;
        while (objects.hasNext()) {
            object = (com.schandorf.elmenorah.POJO.LiteraturePOJO) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$image = ((LiteraturePOJORealmProxyInterface)object).realmGet$image();
                if (realmGet$image != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
                }
                String realmGet$id = ((LiteraturePOJORealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                }
                String realmGet$title = ((LiteraturePOJORealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$category = ((LiteraturePOJORealmProxyInterface)object).realmGet$category();
                if (realmGet$category != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.categoryIndex, rowIndex, realmGet$category, false);
                }
                String realmGet$content = ((LiteraturePOJORealmProxyInterface)object).realmGet$content();
                if (realmGet$content != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
                }
                String realmGet$dateAdded = ((LiteraturePOJORealmProxyInterface)object).realmGet$dateAdded();
                if (realmGet$dateAdded != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateAddedIndex, rowIndex, realmGet$dateAdded, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.schandorf.elmenorah.POJO.LiteraturePOJO object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        long tableNativePtr = table.getNativeTablePointer();
        LiteraturePOJOColumnInfo columnInfo = (LiteraturePOJOColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$image = ((LiteraturePOJORealmProxyInterface)object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
        }
        String realmGet$id = ((LiteraturePOJORealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$title = ((LiteraturePOJORealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$category = ((LiteraturePOJORealmProxyInterface)object).realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.categoryIndex, rowIndex, realmGet$category, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.categoryIndex, rowIndex, false);
        }
        String realmGet$content = ((LiteraturePOJORealmProxyInterface)object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        String realmGet$dateAdded = ((LiteraturePOJORealmProxyInterface)object).realmGet$dateAdded();
        if (realmGet$dateAdded != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateAddedIndex, rowIndex, realmGet$dateAdded, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateAddedIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        long tableNativePtr = table.getNativeTablePointer();
        LiteraturePOJOColumnInfo columnInfo = (LiteraturePOJOColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.LiteraturePOJO.class);
        com.schandorf.elmenorah.POJO.LiteraturePOJO object = null;
        while (objects.hasNext()) {
            object = (com.schandorf.elmenorah.POJO.LiteraturePOJO) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$image = ((LiteraturePOJORealmProxyInterface)object).realmGet$image();
                if (realmGet$image != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
                }
                String realmGet$id = ((LiteraturePOJORealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                String realmGet$title = ((LiteraturePOJORealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$category = ((LiteraturePOJORealmProxyInterface)object).realmGet$category();
                if (realmGet$category != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.categoryIndex, rowIndex, realmGet$category, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.categoryIndex, rowIndex, false);
                }
                String realmGet$content = ((LiteraturePOJORealmProxyInterface)object).realmGet$content();
                if (realmGet$content != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
                }
                String realmGet$dateAdded = ((LiteraturePOJORealmProxyInterface)object).realmGet$dateAdded();
                if (realmGet$dateAdded != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateAddedIndex, rowIndex, realmGet$dateAdded, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateAddedIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.schandorf.elmenorah.POJO.LiteraturePOJO createDetachedCopy(com.schandorf.elmenorah.POJO.LiteraturePOJO realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.schandorf.elmenorah.POJO.LiteraturePOJO unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.schandorf.elmenorah.POJO.LiteraturePOJO)cachedObject.object;
            } else {
                unmanagedObject = (com.schandorf.elmenorah.POJO.LiteraturePOJO)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.schandorf.elmenorah.POJO.LiteraturePOJO();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((LiteraturePOJORealmProxyInterface) unmanagedObject).realmSet$image(((LiteraturePOJORealmProxyInterface) realmObject).realmGet$image());
        ((LiteraturePOJORealmProxyInterface) unmanagedObject).realmSet$id(((LiteraturePOJORealmProxyInterface) realmObject).realmGet$id());
        ((LiteraturePOJORealmProxyInterface) unmanagedObject).realmSet$title(((LiteraturePOJORealmProxyInterface) realmObject).realmGet$title());
        ((LiteraturePOJORealmProxyInterface) unmanagedObject).realmSet$category(((LiteraturePOJORealmProxyInterface) realmObject).realmGet$category());
        ((LiteraturePOJORealmProxyInterface) unmanagedObject).realmSet$content(((LiteraturePOJORealmProxyInterface) realmObject).realmGet$content());
        ((LiteraturePOJORealmProxyInterface) unmanagedObject).realmSet$dateAdded(((LiteraturePOJORealmProxyInterface) realmObject).realmGet$dateAdded());
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
        LiteraturePOJORealmProxy aLiteraturePOJO = (LiteraturePOJORealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aLiteraturePOJO.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLiteraturePOJO.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aLiteraturePOJO.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
