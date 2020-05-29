package model;
import java.sql.*;
public class Payment {
	// A common method to connect to the DB
		private Connection connect() {
			Connection con = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				// Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");

			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		
		public String readPay() {
			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database for reading.";
				}

				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>pay Type</th><th>pay Amount</th><th>pay Date</th><th>pay Email</th><th>Pay Description</th><th>Update</th><th>Remove</th></tr>";

				String query = "SELECT * FROM payments";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				// iterate through the rows in the result set
				while (rs.next()) {
				//	payID,payType,payAmount,payDate,payEmail,PayDesc
					String payID = Integer.toString(rs.getInt("payID"));
					String payType = rs.getString("payType");
					String payAmount = Double.toString(rs.getDouble("payAmount"));
					String payDate = rs.getString("payDate");
					String payEmail = rs.getString("payEmail");
					String PayDesc = rs.getString("payDesc");

					// Add into the html table
					output += "<tr><td><input "
							+ "id=\"hidPayIDUpdate\""
							+ "name=\"hidPayIDUpdate\""
							+ "type=\"hidden\" value=\""
							+ payID + "\">" + payType + "</td>";
					output += "<td>" + payAmount + "</td>";
					output += "<td>" + payDate + "</td>";
					output += "<td>" + payEmail + "</td>";
					output += "<td>" + PayDesc + "</td>";

					// buttons
					output += "<td><input name=\"btnUpdate\""
							+ "type=\"button\""
							+ "value=\"Update\""
							+ "class=\"btnUpdate btn btn-secondary\"></td>"
							+ "<td><form method=\"post\""
							+ "action=\"payment.jsp\">"
							+ "<input name=\"btnRemove\""
							+ "type=\"submit\""
							+ "value=\"Remove\""
							+ "class=\"btn btn-danger\">"
							+ "<input name=\"hidPayIDDelete\""
							+ "type=\"hidden\""
							+ "value=\"" + payID + "\">" + 
							"</form></td></tr>";
				}

				con.close();

				// Complete the html table
				output += "</table>";

			} catch (Exception e) {
				output = "Error while reading the items.";
				System.err.println(e.getMessage());
			}

			return output;
		}
		
		public String insertPay(String type, String amount, String date, String email,String desc) {
			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}

				// create prepared statement
				String query = " insert into payments(`payID`,`payType`,`payAmount`,`payDate`,`payEmail`,`payDesc`) values (?, ?, ?, ?, ?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, type);
				preparedStmt.setDouble(3, Double.parseDouble(amount));
				preparedStmt.setString(4, date);
				preparedStmt.setString(5, email);
				preparedStmt.setString(6, desc);

				// execute the statement
				preparedStmt.execute();
				con.close();

				output = "Inserted successfully";

			} catch (Exception e) {
				output = "Error while inserting the payments.";
				System.err.println(e.getMessage());
			}

			return output;
		}
		
		
		public String deletePay(String payID) {
			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}

				// create a prepared statement
				String query = "delete from payments where payID=?";

				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, Integer.parseInt(payID));

				// execute the statement
				preparedStmt.execute();
				con.close();

				output = "Deleted successfully";
			} catch (Exception e) {
				output = "Error while deleting the payments.";
				System.err.println(e.getMessage());
			}

			return output;
		}
		
		
		public String updatePay(String payID, String type, String amount, String date, String email,String desc) {
			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				// create a prepared statement
				////	payID,payType,payAmount,payDate,payEmail,PayDesc
				String query = "UPDATE payments SET payType=?,payAmount=?,payDate=?,payEmail=?,payDesc=?  WHERE payID=?";

				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setString(1, type);
				preparedStmt.setDouble(2, Double.parseDouble(amount));
				preparedStmt.setString(3, date);
				
				preparedStmt.setString(4, email);
				preparedStmt.setString(5, desc);
				preparedStmt.setInt(6, Integer.parseInt(payID));

				// execute the statement
				preparedStmt.execute();
				con.close();

				output = "Updated successfully";
			} catch (Exception e) {
				output = "Error while updating the payments.";
				System.err.println(e.getMessage());
			}

			return output;
		}

}
