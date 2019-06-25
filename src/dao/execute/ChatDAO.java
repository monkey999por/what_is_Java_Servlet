package dao.execute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.ConnectionDB;
import dao.sql.ChatSQL;
import model.values.ChatValues;

/**
 * @author nogam
 *@see dao.sql.*.javaからsqlを取得して、バインド変数を指定して結果を返すクラス
 */
public class ChatDAO {
	public static Connection connection = null;
	
	/**
	 * @param chatValues
	 * メッセージを登録。ユーザ名もそのまま登録。ここではユーザは誰とか関係ない。5ch的なものとして
	 * 
	 */
	public static void setMessage(ChatValues chatValues) {
		try {
			connection = ConnectionDB.connectDB_mysql();
			PreparedStatement preparedStatement = connection.prepareStatement(ChatSQL.set_message);
			
			preparedStatement.setString(1,chatValues.getUser_name());
			preparedStatement.setString(2,chatValues.getMessage());
			
			connection.setAutoCommit(false);
			preparedStatement.executeUpdate();
			connection.commit();
			
			} catch (Exception e) {
				try {
					connection.rollback();
				} catch (Exception e2) {
					
				}
				e.printStackTrace();
			}finally {
				ConnectionDB.disconnectDB();
			}		
	}
	public static void getAll(ChatValues chatValues) {
		try {
			connection = ConnectionDB.connectDB_mysql();
			PreparedStatement preparedStatement=connection.prepareStatement(ChatSQL.get_all);
			ResultSet result = preparedStatement.executeQuery();
			
			//ほんとはこんなことしたくない
			ChatValues.getDisPlayList().clear();
			while (result.next()) {
				String user_name = result.getString("user_name");
				String message = result.getString("message");
				ChatValues.getDisPlayList().add(user_name + " : \"" +message + "\"");
			}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionDB.disconnectDB();
			}		
	}
}
