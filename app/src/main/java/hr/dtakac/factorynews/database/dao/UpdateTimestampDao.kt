package hr.dtakac.factorynews.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.TypeConverters
import hr.dtakac.factorynews.UPDATE_TIMESTAMP_ID
import hr.dtakac.factorynews.database.converter.ZonedDateTimeConverter
import java.time.ZonedDateTime

@Dao
@TypeConverters(ZonedDateTimeConverter::class)
interface UpdateTimestampDao {
    @Query("""
        INSERT INTO UpdateTimestamp (id, updatedAt) 
        VALUES ($UPDATE_TIMESTAMP_ID, :updatedAt) 
        ON CONFLICT(id) 
        DO UPDATE SET updatedAt = :updatedAt
    """)
    suspend fun insertOrUpdate(updatedAt: ZonedDateTime)

    @Query("SELECT updatedAt FROM UpdateTimestamp WHERE id = $UPDATE_TIMESTAMP_ID")
    suspend fun get(): ZonedDateTime?
}