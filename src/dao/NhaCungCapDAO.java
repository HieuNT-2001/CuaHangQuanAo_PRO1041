/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.NhaCungCap;
import utils.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author HP
 */
public class NhaCungCapDAO {
    public void insert(NhaCungCap cc){
        String sql="INSERT INTO NhaCungCap (TenNCC, SDT, Email, DiaChi)\n" +
        "VALUES (?, ?, ?, ?)";
        Xjdbc.executeUpdate(sql, cc.getTenNCC(),cc.getSdt(),cc.getEmail(),cc.getDiaChi());
    }
    public void update(NhaCungCap cc){
        String sql="UPDATE NhaCungCap SET TenNCC=?, SDT=?, Email=?, DiaChi=?\n" +
        "WHERE MaNCC=?";
        Xjdbc.executeUpdate(sql, cc.getTenNCC(),cc.getSdt(),cc.getEmail(),cc.getDiaChi(),cc.getMaNCC());
    }
    public void delete(String maNCC){
        String sql="DELETE FROM NhaCungCap WHERE MaNCC=?";
        Xjdbc.executeUpdate(sql, maNCC);
    }
    public List<NhaCungCap> select(){
        String sql="SELECT * FROM NhaCungCap";
        return select(sql);
    }
    public NhaCungCap findByID(String maNV){
        String sql="SELECT * FROM NhaCungCap WHERE MaNV=?";
        List<NhaCungCap> lcc=select(sql, maNV);
        return lcc.size()>0 ? lcc.get(0) : null;
    }
    private List<NhaCungCap> select(String sql, Object...args){
        List<NhaCungCap> lcc=new ArrayList<>();
        try{
            ResultSet rs = null;
            try{
                rs=Xjdbc.executeQuery(sql, args);
                while(rs.next()){
                    NhaCungCap cc=readFromResultSet(rs);
                    lcc.add(cc);
                }
            }
            finally{
                rs.getStatement();
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return lcc;
    }
    private NhaCungCap readFromResultSet(ResultSet rs) throws SQLException{
        NhaCungCap cc=new NhaCungCap();
        cc.setMaNCC(rs.getInt("MaNCC"));
        cc.setTenNCC(rs.getString("TenNCC"));
        cc.setSdt(rs.getString("SDT"));
        cc.setEmail(rs.getString("Email"));
        cc.setDiaChi(rs.getString("DiaChi"));
        return cc;
    }
}