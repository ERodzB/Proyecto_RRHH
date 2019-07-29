/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_recursoshumanos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hondu
 */
public class ConexionBD {
    protected static Connection con;// Se crea la variable en la cual tendra la conexion a la BD y espera a ser una variable tipo estatica sino muestra un error
    private static CallableStatement state; //Esta variable es la que llamara a los procedimientos almacenados para que funcionen
    private static ResultSet result; // Puede tomar los resultas hecho por un procedimiento
    public static String Nombre_Usuario;
    public static String Nivel_Autoridad;
    public static String usuario;
    public static String Codigo_Empleado;
    public static int Estado;
    public ConexionBD() {
        try{//Prueba la siguiente secuendia
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=RecursosHumanos","admin","123456789");//Mando la url de la conecion a la BD, el usuario con el cual entrara , su debida contraseña
        }
        catch(Exception ex){ //En caso que la secuencia probada muestre algun error lo atrapa y lo tira como mensaje (Esto hace que el programa no se cierre)
            JOptionPane.showMessageDialog(null,"Error no se pudo conectar"+ex);
        }
    }
    
    
    public String[] login(String user, String pass){
        String[] autoridad= new String[4];
        try{
            state = con.prepareCall("{call InicioSesion (?,?)}"); //Llamo el nombre del procedimiento y los parametros que espera usando (?) en caso de ser 3 (?,?,?)
            state.setString(1,user);//Mando el orden como se esperan los parametros en el procedimiento y el dato que recibirá
            //state.setString("Codigo_Usuario",user) En caso que no funcione el de arriba prueben este
            state.setString(2,pass);
            result=state.executeQuery();
        while(result.next()){//Comienzo a pasar el resultado del procedimiento a variables del programa
            autoridad[0]=result.getString(1);
            autoridad[1]=result.getString(2);
            autoridad[2]=result.getString(3);
            Codigo_Empleado=result.getString(4);
            Estado = result.getInt(5);
        }
            Nombre_Usuario=autoridad[2];//Variables Globales para el Sistema
            Nivel_Autoridad=autoridad[0];//Nivel de autoridad que tendra el usuario al ingresar al Sistema
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
       
         }
        
        return autoridad;
        
    }
    
    
    public void CreacionUsuario(String Codigo_Empleado, String codusuario, String password, String codigo_acceso, String cod_estado)
            throws SQLException{
        
        try{
            state = con.prepareCall("{call CreacionUsuario (?,?,?,?,?,?)}");
            state.setString(1, Codigo_Empleado);
            state.setString(2, codusuario);
            state.setString(3, password);
            state.setString(4, codigo_acceso);
            state.setString(5, cod_estado);
            state.setString(6, this.Codigo_Empleado);
            
            state.execute();//Ejecuta el procedimiento
            JOptionPane.showMessageDialog(null,"Usuario creado correctamente");
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
       
         }
        
    
    }
    public int validacionUsuario(String Codigo_Usuario){
        Integer encontrado=0;
        try{
           state=con.prepareCall("{call RevisarUsuario (?)}");
           state.setString("Codigo_Usuario",Codigo_Usuario);
           result = state.executeQuery();
           while(result.next()){
               encontrado = Integer.parseInt(result.getString(1));
           }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error :"+ex);
        }
        return encontrado;
    }
    public DefaultTableModel Mostrar()
    {
                
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Usuario");
        model.addColumn("Acceso");
        model.addColumn("Estado");
       
            try {
                state = con.prepareCall("{call CargarTabla}");
                result = state.executeQuery();
                while(result.next())
                {
                    Object dato [] = new Object[3];
                    for(int i = 0; i<3; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        return model;
       
    }
    
    
     public DefaultTableModel MostrarDatosEmpleados(int filtro)
    {
        DefaultTableModel model = new DefaultTableModel();
        if(filtro==0)
        {
            model.addColumn("Identidad");
            model.addColumn("Nombre");
            model.addColumn("Puesto");
            model.addColumn("Estado");
             try {
                Integer tamtabla=4;
                state = con.prepareCall("{call DVGEmpleadoDGenerales}");
                result = state.executeQuery();
                while(result.next())
                {
                    Object dato [] = new Object[tamtabla];
                    for(int i = 0; i<tamtabla; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        if(filtro==1)
        {
        model.addColumn("Nombre");
        model.addColumn("Correo");
        model.addColumn("Sueldo");
        model.addColumn("Dirección");
        model.addColumn("Genero");
       
            try {
                Integer tamtabla=5;
                state = con.prepareCall("{call CargarDGVEmpleados}");
                result = state.executeQuery();
                while(result.next())
                {
                    Object dato [] = new Object[tamtabla];
                    for(int i = 0; i<tamtabla; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return model;
    }
  public DefaultTableModel filtrarEmpleados(int tipo, String filtro, int filtrox)
            throws SQLException{
        DefaultTableModel model = new DefaultTableModel();
        try{
            state = con.prepareCall("{call filtroEmpleados (?,?,?)}");
            state.setInt(1, tipo);
            state.setString(2, filtro);
            state.setInt(3, filtrox);
            result = state.executeQuery();

            if(tipo==0)
            {
            model.addColumn("Identidad");
            model.addColumn("Nombre");
            model.addColumn("Puesto");
            model.addColumn("Estado");
             try {
                Integer tamtabla=4;
                while(result.next())
                {
                    Object dato [] = new Object[tamtabla];
                    for(int i = 0; i<tamtabla; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
                }
              catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            }
            else
            {
                model.addColumn("Nombre");
                model.addColumn("Correo");
                model.addColumn("Sueldo");
                model.addColumn("Dirección");
                model.addColumn("Genero");
       
            try {
                Integer tamtabla=5;
                while(result.next())
                {
                    Object dato [] = new Object[tamtabla];
                    for(int i = 0; i<tamtabla; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
       
         }
        return model;
    }
     public DefaultTableModel filtrarymostrarusuarios(int tipo, String filtro, int filtrox)
            throws SQLException{
        DefaultTableModel model = new DefaultTableModel();
        try{
            state = con.prepareCall("{call CargarDatosUsuarios (?,?,?)}");
            state.setInt(1, tipo);
            state.setString(2, filtro);
            state.setInt(3, filtrox);
            result = state.executeQuery();

            if(tipo==1)
            {
            model.addColumn("Usuario");
            model.addColumn("Contraseña");
            model.addColumn("Dueño del Usuario");
            model.addColumn("Nivel de Acceso");
            model.addColumn("Estado del Usuario");
             try {
                Integer tamtabla=5;
                while(result.next())
                {
                    Object dato [] = new Object[tamtabla];
                    for(int i = 0; i<tamtabla; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
                }
              catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            }
            else
            {
                model.addColumn("Usuario");
                model.addColumn("Dueño del Usuario");
                model.addColumn("Estado del Usuario");
       
            try {
                Integer tamtabla=3;
                while(result.next())
                {
                    Object dato [] = new Object[tamtabla];
                    for(int i = 0; i<tamtabla; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
       
         }
        return model;
    }
    
    public DefaultComboBoxModel cargarComboAcceso(){
        
        DefaultComboBoxModel combA = new DefaultComboBoxModel();
            
        try {            
            state = con.prepareCall("{call CargaCmbAcceso}");            
            result = state.executeQuery();
            while(result.next())
            {
                combA.addElement(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return combA;
        
    }
    public DefaultComboBoxModel cargarComboEstado(){
        
        DefaultComboBoxModel combB = new DefaultComboBoxModel();
            
        try {            
            state = con.prepareCall("{call CargaCmbEstado}");            
            result = state.executeQuery();
            while(result.next())
            {
                combB.addElement(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return combB;
        
    }
    public DefaultComboBoxModel cargarComboGenero(){
        
        DefaultComboBoxModel combC = new DefaultComboBoxModel();
            
        try {            
            state = con.prepareCall("{call CargaCmbGenero}");            
            result = state.executeQuery();
            while(result.next())
            {
                combC.addElement(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return combC;
        
    }
    public DefaultComboBoxModel cargarComboPuesto(){
        
        DefaultComboBoxModel combD = new DefaultComboBoxModel();
            
        try {            
            state = con.prepareCall("{call CargaCmbPuesto}");            
            result = state.executeQuery();
            while(result.next())
            {
                combD.addElement(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return combD;
        
    }
    
    public void ModificacionUsuario(String codusuario, int cod_acceso, int cod_estado)
            throws SQLException{
        
        try{
            state = con.prepareCall("{call ModificarUsuario (?,?,?)}");
            state.setString(1, codusuario);
            state.setInt(2, cod_acceso);
            state.setInt(3, cod_estado);
            
            state.execute();//Ejecuta el procedimiento
            
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
       
         }
        
    
    }
    
    public DefaultTableModel CargarUsuarios()
    {
                
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Usuario");
        model.addColumn("Empleado");
       
            try {
                state = con.prepareCall("{call CargarUsuario}");
                result = state.executeQuery();
                while(result.next())
                {
                    Object dato [] = new Object[3];
                    for(int i = 0; i<2; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        return model;
       
    }
    public void CambiarPassword(String Codigo_Usuario, String Password_Usuario){
        try{
            state = con.prepareCall("{call CambiarPassword (?,?)}");
            state.setString(1,Codigo_Usuario);
            state.setString(2,Password_Usuario);
            state.execute();
            JOptionPane.showMessageDialog(null,"Contraseña Modificada correctamente");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
    }
    public int AntiguaPassword(String Codigo_Usuario, String Password_Usuario){
        int res=0;
        try{
            state = con.prepareCall("{call AntiguaPassword (?,?)}");
            state.setString(1,Codigo_Usuario);
            state.setString(2,Password_Usuario);
            result=state.executeQuery();
            while(result.next()){
                res=result.getInt(1);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        return res;
    }
    
    public DefaultTableModel CargarEmpleadosSinUser()
    {
                
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Empleado");
       
            try {
                state = con.prepareCall("{call EmpleadoSinUser}");
                result = state.executeQuery();
                while(result.next())
                {
                    Object dato [] = new Object[3];
                    for(int i = 0; i<2; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        return model;
       
    }
    public int validoRecuperacion(String Codigo_Usuario, String Correo){
        int res =0;
        try{
            state= con.prepareCall("{call ValidacionContra (?,?)}");
            state.setString(1,Codigo_Usuario);
            state.setString(2, Correo);
            result=state.executeQuery();
            while(result.next()){
                res=result.getInt(1);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        return res;
    }
    public void ObtenerPasssword(String Codigo_Usuario, String Correo){
        Correo mail = new Correo();
        String Contra=" ";
        try{
            state = con.prepareCall("{call ObtenerPass (?)}");
            state.setString(1, Codigo_Usuario);
            result = state.executeQuery();
                while(result.next()){
                    Contra=result.getString(1);
                }
                JOptionPane.showMessageDialog(null,Contra);
                mail.mandarCorreo(Contra, Correo);
                UpdatePassword(Codigo_Usuario,Contra);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
    }
    public void UpdatePassword(String Codigo_Usuario,String Password){
        
        
        try{
             state= con.prepareCall("{call UpdatePassword (?,?)}");
                state.setString(1,Codigo_Usuario);
                state.setString(2, Password);
                state.execute();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
    }
    
    public DefaultTableModel CargarPuestos()
    {
                
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numero");        
        model.addColumn("Nombre");
        model.addColumn("Descripcion");
       
            try {
                state = con.prepareCall("{call CargarPuesto}");
                result = state.executeQuery();
                while(result.next())
                {
                    Object dato [] = new Object[3];
                    for(int i = 0; i<3; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        return model;
       
    }
    
    public void ModificacionPuestos(int codpuesto, String puesto, String descripcion)
            throws SQLException{
        
        try{
            state = con.prepareCall("{call ModificarPuesto (?,?,?)}");
            state.setInt(1, codpuesto);
            state.setString(2, puesto);
            state.setString(3, descripcion);
            
            state.execute();//Ejecuta el procedimiento
            
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
       
         }
            
    }
    
    public DefaultTableModel CargarEmpleadoBono()
    {
                
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Identidad");        
        model.addColumn("Empleado");
        model.addColumn("Sueldo");
        model.addColumn("Estado");
        
       
            try {
                state = con.prepareCall("{call CargaEmpleadoBono}");
                result = state.executeQuery();
                while(result.next())
                {
                    Object dato [] = new Object[4];
                    for(int i = 0; i<4; i++)
                    {
                        dato[i] = result.getString(i+1);
                    }
                    model.addRow(dato);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        return model;
       
    }
    
    public void AgregarBono(int evento, String codempleado, double monto)
            throws SQLException{
        
        try{
            state = con.prepareCall("{call AgregarBono (?,?,?,?)}");
            state.setInt(1, evento);
            state.setString(2, codempleado);
            state.setDouble(3, monto);
            state.setString(4, this.Codigo_Empleado);
            
            state.execute();//Ejecuta el procedimiento            
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
       
         }
        
    
    }
    
    
}
