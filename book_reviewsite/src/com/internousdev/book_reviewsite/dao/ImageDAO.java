package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.book_reviewsite.dto.ImageDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class ImageDAO {

	public List<ImageDTO> getImage() {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ImageDTO> imageDTO = new ArrayList<ImageDTO>();

		String sql = "SELECT * FROM image_table";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				ImageDTO imageInfo = new ImageDTO();
				imageInfo.setImageFilePath(resultSet.getString("image_file_path"));
				imageInfo.setImageFileName(resultSet.getString("image_file_name"));
				imageDTO.add(imageInfo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return imageDTO;
	}

}