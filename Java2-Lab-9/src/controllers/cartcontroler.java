package controllers;

import com.mysql.cj.MysqlConnection;
import models.BookModel;
import models.CartModel;
import views.CartView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartControler {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore";
    private static final String connUser = "root";
    private static final String connPass = "";
    private Statement stmt;
    private PreparedStatement pStmt;
    private ResultSet rset;
    private ResultSetMetaData rsMd;
    List<CartModel> cartModelList = new ArrayList<>();

    public boolean addToCart(CartModel item){
        if(findItem(item.getBookID())>= 0){
            System.out.println("This book already added!");
            return false;
        }
        cartModelList.add(item);
        return true;
    }
    private int findItem(int BookID){
        for (int i=0; i< this.cartModelList.size(); i++){
            CartModel cartModel = this.cartModelList.get(i);
            if (cartModel.getBookID() == BookID){
                return i;
            }
        }
        return -1;
    }
}
