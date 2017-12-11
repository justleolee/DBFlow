package com.raizlabs.dbflow5.adapter.queriable

import com.raizlabs.dbflow5.database.DatabaseWrapper
import com.raizlabs.dbflow5.database.FlowCursor

/**
 * Description: Responsible for loading data into a single object.
 */
open class SingleModelLoader<T : Any>(modelClass: Class<T>)
    : ModelLoader<T, T>(modelClass) {

    open fun convertToData(cursor: FlowCursor,
                           moveToFirst: Boolean,
                           databaseWrapper: DatabaseWrapper): T? {
        var _data: T? = null
        if (!moveToFirst || cursor.moveToFirst()) {
            _data = instanceAdapter.loadFromCursor(cursor, databaseWrapper)
        }
        return _data
    }

    override fun convertToData(cursor: FlowCursor, databaseWrapper: DatabaseWrapper): T? {
        return convertToData(cursor, true, databaseWrapper)
    }
}