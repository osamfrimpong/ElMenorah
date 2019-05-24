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

public class AppRegistrationDataPOJORealmProxy extends com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO
    implements RealmObjectProxy, AppRegistrationDataPOJORealmProxyInterface {

    static final class AppRegistrationDataPOJOColumnInfo extends ColumnInfo
        implements Cloneable {

        public long nameIndex;
        public long passwordIndex;
        public long emailIndex;
        public long fullnameIndex;
        public long dateOfBirthIndex;
        public long genderIndex;
        public long loggedInIndex;

        AppRegistrationDataPOJOColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(7);
            this.nameIndex = getValidColumnIndex(path, table, "AppRegistrationDataPOJO", "name");
            indicesMap.put("name", this.nameIndex);
            this.passwordIndex = getValidColumnIndex(path, table, "AppRegistrationDataPOJO", "password");
            indicesMap.put("password", this.passwordIndex);
            this.emailIndex = getValidColumnIndex(path, table, "AppRegistrationDataPOJO", "email");
            indicesMap.put("email", this.emailIndex);
            this.fullnameIndex = getValidColumnIndex(path, table, "AppRegistrationDataPOJO", "fullname");
            indicesMap.put("fullname", this.fullnameIndex);
            this.dateOfBirthIndex = getValidColumnIndex(path, table, "AppRegistrationDataPOJO", "dateOfBirth");
            indicesMap.put("dateOfBirth", this.dateOfBirthIndex);
            this.genderIndex = getValidColumnIndex(path, table, "AppRegistrationDataPOJO", "gender");
            indicesMap.put("gender", this.genderIndex);
            this.loggedInIndex = getValidColumnIndex(path, table, "AppRegistrationDataPOJO", "loggedIn");
            indicesMap.put("loggedIn", this.loggedInIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final AppRegistrationDataPOJOColumnInfo otherInfo = (AppRegistrationDataPOJOColumnInfo) other;
            this.nameIndex = otherInfo.nameIndex;
            this.passwordIndex = otherInfo.passwordIndex;
            this.emailIndex = otherInfo.emailIndex;
            this.fullnameIndex = otherInfo.fullnameIndex;
            this.dateOfBirthIndex = otherInfo.dateOfBirthIndex;
            this.genderIndex = otherInfo.genderIndex;
            this.loggedInIndex = otherInfo.loggedInIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final AppRegistrationDataPOJOColumnInfo clone() {
            return (AppRegistrationDataPOJOColumnInfo) super.clone();
        }

    }
    private AppRegistrationDataPOJOColumnInfo columnInfo;
    private ProxyState<com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("password");
        fieldNames.add("email");
        fieldNames.add("fullname");
        fieldNames.add("dateOfBirth");
        fieldNames.add("gender");
        fieldNames.add("loggedIn");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    AppRegistrationDataPOJORealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AppRegistrationDataPOJOColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'name' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordIndex);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fullname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fullnameIndex);
    }

    @Override
    public void realmSet$fullname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fullnameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fullnameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fullnameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fullnameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$dateOfBirth() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateOfBirthIndex);
    }

    @Override
    public void realmSet$dateOfBirth(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateOfBirthIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dateOfBirthIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateOfBirthIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dateOfBirthIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$gender() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genderIndex);
    }

    @Override
    public void realmSet$gender(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.genderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.genderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genderIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genderIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$loggedIn() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.loggedInIndex);
    }

    @Override
    public void realmSet$loggedIn(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.loggedInIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.loggedInIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("AppRegistrationDataPOJO")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("AppRegistrationDataPOJO");
            realmObjectSchema.add("name", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("fullname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("dateOfBirth", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("gender", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("loggedIn", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("AppRegistrationDataPOJO");
    }

    public static AppRegistrationDataPOJOColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_AppRegistrationDataPOJO")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'AppRegistrationDataPOJO' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_AppRegistrationDataPOJO");
        final long columnCount = table.getColumnCount();
        if (columnCount != 7) {
            if (columnCount < 7) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final AppRegistrationDataPOJOColumnInfo columnInfo = new AppRegistrationDataPOJOColumnInfo(sharedRealm.getPath(), table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'name' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.nameIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field name");
            }
        }

        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'name' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("name"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'name' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("password")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'password' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("password") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'password' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.passwordIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'password' is required. Either set @Required to field 'password' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("email")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("email") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'email' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.emailIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'email' is required. Either set @Required to field 'email' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fullname")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fullname' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fullname") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fullname' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fullnameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fullname' is required. Either set @Required to field 'fullname' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("dateOfBirth")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateOfBirth' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("dateOfBirth") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateOfBirth' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.dateOfBirthIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateOfBirth' is required. Either set @Required to field 'dateOfBirth' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("gender")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gender' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("gender") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'gender' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.genderIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gender' is required. Either set @Required to field 'gender' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("loggedIn")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'loggedIn' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("loggedIn") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'loggedIn' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.loggedInIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'loggedIn' does support null values in the existing Realm file. Use corresponding boxed type for field 'loggedIn' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_AppRegistrationDataPOJO";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO obj = null;
        if (update) {
            Table table = realm.getTable(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("name")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("name"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class), false, Collections.<String> emptyList());
                    obj = new io.realm.AppRegistrationDataPOJORealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("name")) {
                if (json.isNull("name")) {
                    obj = (io.realm.AppRegistrationDataPOJORealmProxy) realm.createObjectInternal(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.AppRegistrationDataPOJORealmProxy) realm.createObjectInternal(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class, json.getString("name"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'name'.");
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$password(null);
            } else {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$email(null);
            } else {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("fullname")) {
            if (json.isNull("fullname")) {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$fullname(null);
            } else {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$fullname((String) json.getString("fullname"));
            }
        }
        if (json.has("dateOfBirth")) {
            if (json.isNull("dateOfBirth")) {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$dateOfBirth(null);
            } else {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$dateOfBirth((String) json.getString("dateOfBirth"));
            }
        }
        if (json.has("gender")) {
            if (json.isNull("gender")) {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$gender(null);
            } else {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$gender((String) json.getString("gender"));
            }
        }
        if (json.has("loggedIn")) {
            if (json.isNull("loggedIn")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'loggedIn' to null.");
            } else {
                ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$loggedIn((boolean) json.getBoolean("loggedIn"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO obj = new com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("password")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$password(null);
                } else {
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$password((String) reader.nextString());
                }
            } else if (name.equals("email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$email(null);
                } else {
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$email((String) reader.nextString());
                }
            } else if (name.equals("fullname")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$fullname(null);
                } else {
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$fullname((String) reader.nextString());
                }
            } else if (name.equals("dateOfBirth")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$dateOfBirth(null);
                } else {
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$dateOfBirth((String) reader.nextString());
                }
            } else if (name.equals("gender")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$gender(null);
                } else {
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$gender((String) reader.nextString());
                }
            } else if (name.equals("loggedIn")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'loggedIn' to null.");
                } else {
                    ((AppRegistrationDataPOJORealmProxyInterface) obj).realmSet$loggedIn((boolean) reader.nextBoolean());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'name'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO copyOrUpdate(Realm realm, com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) cachedRealmObject;
        } else {
            com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((AppRegistrationDataPOJORealmProxyInterface) object).realmGet$name();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.AppRegistrationDataPOJORealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO copy(Realm realm, com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO realmObject = realm.createObjectInternal(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class, ((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$name(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$password(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$password());
            ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$email(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$email());
            ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$fullname(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$fullname());
            ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$dateOfBirth(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$dateOfBirth());
            ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$gender(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$gender());
            ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$loggedIn(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$loggedIn());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        long tableNativePtr = table.getNativeTablePointer();
        AppRegistrationDataPOJOColumnInfo columnInfo = (AppRegistrationDataPOJOColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((AppRegistrationDataPOJORealmProxyInterface) object).realmGet$name();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$password = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }
        String realmGet$email = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$fullname = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$fullname();
        if (realmGet$fullname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
        }
        String realmGet$dateOfBirth = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$dateOfBirth();
        if (realmGet$dateOfBirth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateOfBirthIndex, rowIndex, realmGet$dateOfBirth, false);
        }
        String realmGet$gender = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.loggedInIndex, rowIndex, ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$loggedIn(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        long tableNativePtr = table.getNativeTablePointer();
        AppRegistrationDataPOJOColumnInfo columnInfo = (AppRegistrationDataPOJOColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO object = null;
        while (objects.hasNext()) {
            object = (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((AppRegistrationDataPOJORealmProxyInterface) object).realmGet$name();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$password = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$password();
                if (realmGet$password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
                }
                String realmGet$email = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                }
                String realmGet$fullname = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$fullname();
                if (realmGet$fullname != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
                }
                String realmGet$dateOfBirth = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$dateOfBirth();
                if (realmGet$dateOfBirth != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateOfBirthIndex, rowIndex, realmGet$dateOfBirth, false);
                }
                String realmGet$gender = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$gender();
                if (realmGet$gender != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.loggedInIndex, rowIndex, ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$loggedIn(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        long tableNativePtr = table.getNativeTablePointer();
        AppRegistrationDataPOJOColumnInfo columnInfo = (AppRegistrationDataPOJOColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((AppRegistrationDataPOJORealmProxyInterface) object).realmGet$name();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$password = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }
        String realmGet$email = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$fullname = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$fullname();
        if (realmGet$fullname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fullnameIndex, rowIndex, false);
        }
        String realmGet$dateOfBirth = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$dateOfBirth();
        if (realmGet$dateOfBirth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateOfBirthIndex, rowIndex, realmGet$dateOfBirth, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateOfBirthIndex, rowIndex, false);
        }
        String realmGet$gender = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.loggedInIndex, rowIndex, ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$loggedIn(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        long tableNativePtr = table.getNativeTablePointer();
        AppRegistrationDataPOJOColumnInfo columnInfo = (AppRegistrationDataPOJOColumnInfo) realm.schema.getColumnInfo(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO object = null;
        while (objects.hasNext()) {
            object = (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((AppRegistrationDataPOJORealmProxyInterface) object).realmGet$name();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$password = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$password();
                if (realmGet$password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
                }
                String realmGet$email = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
                }
                String realmGet$fullname = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$fullname();
                if (realmGet$fullname != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fullnameIndex, rowIndex, false);
                }
                String realmGet$dateOfBirth = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$dateOfBirth();
                if (realmGet$dateOfBirth != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateOfBirthIndex, rowIndex, realmGet$dateOfBirth, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateOfBirthIndex, rowIndex, false);
                }
                String realmGet$gender = ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$gender();
                if (realmGet$gender != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.loggedInIndex, rowIndex, ((AppRegistrationDataPOJORealmProxyInterface)object).realmGet$loggedIn(), false);
            }
        }
    }

    public static com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO createDetachedCopy(com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO)cachedObject.object;
            } else {
                unmanagedObject = (com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((AppRegistrationDataPOJORealmProxyInterface) unmanagedObject).realmSet$name(((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmGet$name());
        ((AppRegistrationDataPOJORealmProxyInterface) unmanagedObject).realmSet$password(((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmGet$password());
        ((AppRegistrationDataPOJORealmProxyInterface) unmanagedObject).realmSet$email(((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmGet$email());
        ((AppRegistrationDataPOJORealmProxyInterface) unmanagedObject).realmSet$fullname(((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmGet$fullname());
        ((AppRegistrationDataPOJORealmProxyInterface) unmanagedObject).realmSet$dateOfBirth(((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmGet$dateOfBirth());
        ((AppRegistrationDataPOJORealmProxyInterface) unmanagedObject).realmSet$gender(((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmGet$gender());
        ((AppRegistrationDataPOJORealmProxyInterface) unmanagedObject).realmSet$loggedIn(((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmGet$loggedIn());
        return unmanagedObject;
    }

    static com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO update(Realm realm, com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO realmObject, com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$password(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$password());
        ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$email(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$email());
        ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$fullname(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$fullname());
        ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$dateOfBirth(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$dateOfBirth());
        ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$gender(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$gender());
        ((AppRegistrationDataPOJORealmProxyInterface) realmObject).realmSet$loggedIn(((AppRegistrationDataPOJORealmProxyInterface) newObject).realmGet$loggedIn());
        return realmObject;
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
        AppRegistrationDataPOJORealmProxy aAppRegistrationDataPOJO = (AppRegistrationDataPOJORealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAppRegistrationDataPOJO.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAppRegistrationDataPOJO.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAppRegistrationDataPOJO.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
