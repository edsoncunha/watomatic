package com.parishod.watomatic.model.logs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MessageLogsDao {
    @Query("SELECT message_logs.notif_reply_time FROM MESSAGE_LOGS " +
            "INNER JOIN app_packages ON app_packages.`index` = message_logs.`index` " +
            "WHERE app_packages.package_name=:packageName AND message_logs.notif_title=:title ORDER BY notif_reply_time DESC LIMIT 1"
    )
    long getLastReplyTimeStamp(String title, String packageName);

    @Insert
    void logReply(MessageLog log);
}
