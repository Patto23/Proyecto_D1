package Serlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.ViewModelEmpleados;
import Models.ViewModelProductos;
import Models.ViewModelProveedores;
import Models.ViewModelFacturas;
import Models.ViewModelUsuarios;
import Models.ViewModelCategorias;
import Models.ViewModelAsignacionRolesOpciones;
import Models.ViewMoldelClientes;

public class ServletPrincipal extends HttpServlet {
    
    private final String usuario = "administrador";
    private final String contrasenia = "root";
    private final String servidor = "localhost:1433";
    private final String bd = "Supermercado";
    
    String url = "jdbc:sqlserver://"
            + servidor
            + ";databaseName=" + bd
            + ";user=" + usuario
            + ";password=" + contrasenia
            + ";encrypt=false;truServerCertificate=false;";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPrincipal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPrincipal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void mostrarEmpleados(HttpServletRequest request, HttpServletResponse response){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
             try(Connection conn = DriverManager.getConnection(url)){
                request.setAttribute("mensaje_conexion", "Ok!");
                String sqlQuery = "select * from Empleados";
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
                ResultSet rs = pstmt.executeQuery();
                ArrayList<ViewModelEmpleados> listaEmpleados = new ArrayList<>();
                while (rs.next()) {
                    ViewModelEmpleados empleado = new ViewModelEmpleados();
                    empleado.setIdEmpleado(rs.getInt("IdEmpleado"));
                    empleado.setNombresEmpleados(rs.getString("nombresEmpleado"));
                    empleado.setApellidosEmpleados(rs.getString("apellidosEmpleados"));
                    empleado.setFechaNacEmpleados(rs.getString("fechaNacEmpleados"));
                    empleado.setTelefono(rs.getString("telefono"));
                    empleado.setCorreo(rs.getString("correo"));
                    listaEmpleados.add(empleado);
                }               
                request.setAttribute("listaEmpleados", listaEmpleados);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensaje_conexion", ex.getMessage());
            ex.printStackTrace();
        }
        }
    public void mostrarProductos(HttpServletRequest request, HttpServletResponse response){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            try(Connection conn = DriverManager.getConnection(url)){
            request.setAttribute("mensaje_conexion", "Ok!");
            String sqlQuery = "select * from Productos p "+"  JOIN Categorias c ON p.idCategoria = c.idCategoria";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<ViewModelProductos> listaProducto = new ArrayList<>();
            while (rs.next()) {
                 ViewModelProductos producto = new ViewModelProductos();
                 producto.setIdProducto(rs.getInt("IdProducto"));
                 producto.setNombreProducto(rs.getString("nombreproducto"));
                 producto.setIdCategoria(rs.getInt("IdCategoria"));
                 producto.setCategoriaNombre(rs.getString("categoria"));
                 producto.setIdProveedor(rs.getInt("IdProveedor"));
                 producto.setPrecio(rs.getString("precio"));
                 listaProducto.add(producto);
            }
            request.setAttribute("listaProducto",listaProducto);
            }
            
        }catch (SQLException | ClassNotFoundException ex){
             request.setAttribute("mensaje_conexion", ex.getMessage());
            ex.printStackTrace();
        }
    
    }
    public void MostrarProveedores(HttpServletRequest request, HttpServletResponse response){
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             
              try(Connection conn = DriverManager.getConnection(url)){
              request.setAttribute("mensaje_conexion", "Ok!");
              String sqlQuery = "select * from Proveedores";
              PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
              ResultSet rs = pstmt.executeQuery();
              ArrayList<ViewModelProveedores> listaProveedores = new ArrayList<>();
              while (rs.next()) {
                  ViewModelProveedores proveedor = new ViewModelProveedores();
                  proveedor.setIdProveedor(rs.getInt("IdProveedor"));
                  proveedor.setNombredelProveedor(rs.getString("nombredelProveedor"));
                  proveedor.setDireccion(rs.getString("direccion"));
                  proveedor.setTelefono(rs.getString("telefono"));
                  proveedor.setCorreoElectronico(rs.getString("correoElectronico"));
                  listaProveedores.add(proveedor);
              }
              request.setAttribute("listaProveedores",listaProveedores);
              }
        }catch (SQLException | ClassNotFoundException ex){
             request.setAttribute("mensaje_conexion", ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void MostrarFacturas(HttpServletRequest request, HttpServletResponse response){
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            try(Connection conn = DriverManager.getConnection(url)){
            request.setAttribute("mensaje_conexion", "ok");
            String sqlQuery = "select * from Facturas";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<ViewModelFacturas> listaFacturas = new ArrayList<>();
            while (rs.next()) {
                ViewModelFacturas factura = new ViewModelFacturas();
                factura.setIdFactura(rs.getInt("IdFactura"));
                factura.setIDFormadePago(rs.getInt("IDFormadePago"));
                factura.setIdCliente(rs.getInt("IdCliente"));
                factura.setIdUsusario(rs.getInt("IdUsuario"));
                factura.setTotalCompra(rs.getString("totalCompra"));
                listaFacturas.add(factura);
            }
            request.setAttribute("listaFacturas",listaFacturas);
            }
        }catch (SQLException | ClassNotFoundException ex){
             request.setAttribute("mensaje_conexion", ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void MostrarUsuarios(HttpServletRequest request, HttpServletResponse response){
        try{
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try(Connection conn = DriverManager.getConnection(url)){
            request.setAttribute("mensaje_conexion", "ok");
            String sqlQuery = "select * from Usuarios";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<ViewModelUsuarios> listaUsuarios = new ArrayList<>();
            while (rs.next()) {
                ViewModelUsuarios Usuario = new ViewModelUsuarios();
                Usuario.setIdUsuario(rs.getInt("IdUsuario"));
                Usuario.setUsuario(rs.getString("Usuario"));
                Usuario.setClave(rs.getString("Clave"));
                Usuario.setIdEmpleado(rs.getInt("IdEmpleado"));
                Usuario.setIdRol(rs.getInt("IdRol"));
                listaUsuarios.add(Usuario);
            }
            request.setAttribute("listaUsuarios",listaUsuarios);
            }
        }
        catch (SQLException | ClassNotFoundException ex){
             request.setAttribute("mensaje_conexion", ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void MostarCategorias(HttpServletRequest request, HttpServletResponse response){
        try{
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try(Connection conn = DriverManager.getConnection(url)){
            request.setAttribute("mensaje_conexion", "ok");
            String sqlQuery = "select * from Categorias";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<ViewModelCategorias> listaCategorias = new ArrayList<>();
            while (rs.next()) {
                ViewModelCategorias Categoria = new ViewModelCategorias();
                Categoria.setIdCategoria(rs.getInt("idCategoria"));
                Categoria.setCategoria(rs.getString("categoria"));
                listaCategorias.add(Categoria);
            }
            request.setAttribute("listaCategorias",listaCategorias);
            }
        }
        catch (SQLException | ClassNotFoundException ex){
             request.setAttribute("mensaje_conexion", ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void MostrarAsigancionRolesOpciones(HttpServletRequest request, HttpServletResponse response){
        try{
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try(Connection conn = DriverManager.getConnection(url)){
            request.setAttribute("mensaje_conexion", "ok");
            String sqlQuery = "select * from AsigancionRolesOpciones ";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = pstmt.executeQuery();
            ArrayList< ViewModelAsignacionRolesOpciones > listaAsigancionRolesOpciones = new ArrayList<>();
            while (rs.next()){
                ViewModelAsignacionRolesOpciones  AsignacionRoles = new  ViewModelAsignacionRolesOpciones ();
                AsignacionRoles.setIdAsignacionRol(rs.getInt("IdAsigancionRol"));
                AsignacionRoles.setIdRol(rs.getInt("IdRol"));
                AsignacionRoles.setIdOpcion(rs.getInt("IdOpcion"));
                listaAsigancionRolesOpciones.add(AsignacionRoles);
            }
            request.setAttribute("listaAsigancionRolesOpciones",listaAsigancionRolesOpciones);
            }
        }
        catch (SQLException | ClassNotFoundException ex){
             request.setAttribute("mensaje_conexion", ex.getMessage());
            ex.printStackTrace();
        }    
    }
    public void MostrarClientes(HttpServletRequest request, HttpServletResponse response){
        try{
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try(Connection conn = DriverManager.getConnection(url)){
            request.setAttribute("mensaje_conexion", "ok");
            String sqlQuery = "select * from Clientes";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = pstmt.executeQuery();
            ArrayList< ViewMoldelClientes > listaClientes = new ArrayList<>();
            while (rs.next()){
            ViewMoldelClientes Cliente = new ViewMoldelClientes();
            Cliente.setIdCliente(rs.getInt("IdCliente"));
            Cliente.setNombre(rs.getString("Nombre"));
            Cliente.setApellido(rs.getString("Apellido"));
            Cliente.setDireccion(rs.getString("Direccion"));
            Cliente.setDui(rs.getString("Dui"));
            Cliente.setNumeroTelefonico(rs.getString("NumeroTelefonico"));
            Cliente.setEmail(rs.getString("email"));
            listaClientes.add(Cliente);
            }
            request.setAttribute("listaClientes",listaClientes);
            }
        }
        catch (SQLException | ClassNotFoundException ex){
             request.setAttribute("mensaje_conexion", ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void agregarEmpleado(HttpServletRequest request, HttpServletResponse response){
           String nombresEmpleados = request.getParameter("nombresEmpleados");
           String apellidosEmpleados = request.getParameter("apellidosEmpleados");
           String fechaNacEmpleados = request.getParameter("fechaNacEmpleados");
           String telefono = request.getParameter("telefono");
           String correo = request.getParameter("correo");
           
           
           try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try(Connection conn = DriverManager.getConnection(url)){
                request.setAttribute("mensaje_conexion", "Ok!");
                String sql = "insert into Empleados values (?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,nombresEmpleados);
                pstmt.setString(2, apellidosEmpleados);
                pstmt.setString(3,fechaNacEmpleados);
                pstmt.setString(4,telefono);
                pstmt.setString(5, correo);
                int registros = pstmt.executeUpdate();
                if (registros > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("error",false);
                }
              }
           
        } catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
      }

}
    public void ModificarEmpleado(HttpServletRequest request, HttpServletResponse response){
        
        String IdEmpleado = request.getParameter("IdEmpleado");
        String nombresEmpleados = request.getParameter("nombresEmpleados");
        String apellidosEmpleados = request.getParameter("apellidosEmpleados");
        String fechaNacEmpleados = request.getParameter("fechaNacEmpleados");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url)) {
                request.setAttribute("mensaje_conexion", "Ok!");
                
                String sql = "update Empleados set "
                 + "nombresEmpleados='"+nombresEmpleados+"', "
                 + "apellidosEmpleados='"+apellidosEmpleados+"', "
                 + "fechaNacEmpleados='"+fechaNacEmpleados+"', "
                 + "telefono='"+telefono+"', "
                 + "correo='"+correo+"', " 
                 + "where IdEmpleado='"+IdEmpleado+"'";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                int registros = pstmt.executeUpdate();
                if (registros > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("exito", false);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
        }
    
    }
    public void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response){
        String IdEmpleado = request.getParameter("ID_Empleado");
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try(Connection conn = DriverManager.getConnection(url)) {
                request.setAttribute("mensaje_conexion","ok!");
                String sql = "delete from Empleados where IdEmpleado='" + IdEmpleado + "'";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                int registros = pstmt.executeUpdate();
                if (registros > 0){
                    request.getSession().setAttribute("exito", true);
                } else {
                   request.getSession().setAttribute("exito",false);
                }
                
            }
        }catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
        }
    }
    public void agregarClientes(HttpServletRequest request, HttpServletResponse response){
           String IdCliente = request.getParameter("IdCliente");
           String Nombre = request.getParameter("Nombre");
           String Apellido = request.getParameter("Apellido");
           String Direccion = request.getParameter("Direccion");
           String Dui = request.getParameter("Dui");
           String NumeroTelefonico = request.getParameter("NumeroTelefonico");
           String email = request.getParameter("email");
           
           
           try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try(Connection conn = DriverManager.getConnection(url)){
                request.setAttribute("mensaje_conexion", "Ok!");
                String sql = "insert into Cliente values (?,?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,Nombre);
                pstmt.setString(2, Apellido);
                pstmt.setString(3,Direccion);
                pstmt.setString(4,Dui);
                pstmt.setString(5, NumeroTelefonico);
                pstmt.setString(5, email);
                int registros = pstmt.executeUpdate();
                if (registros > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("exito",true);
                }
              }
           
        } catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
      }

} 
    public void ModificarCliente(HttpServletRequest request, HttpServletResponse response){
        
        String IdEmpleado = request.getParameter("IdEmpleado");
        String nombresEmpleados = request.getParameter("nombresEmpleados");
        String apellidosEmpleados = request.getParameter("apellidosEmpleados");
        String fechaNacEmpleados = request.getParameter("fechaNacEmpleados");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url)) {
                request.setAttribute("mensaje_conexion", "Ok!");
                
                String sql = "update Empleados set "
                 + "nombresEmpleados='"+nombresEmpleados+"', "
                 + "apellidosEmpleados='"+apellidosEmpleados+"', "
                 + "fechaNacEmpleados='"+fechaNacEmpleados+"', "
                 + "telefono='"+telefono+"', "
                 + "correo='"+correo+"', " 
                 + "where IdEmpleado='"+IdEmpleado+"'";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                int registros = pstmt.executeUpdate();
                if (registros > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("exito", false);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
        }
    
    }
public void eliminarCliente(HttpServletRequest request, HttpServletResponse response){
        String IdCliente = request.getParameter("IdEmpleado");
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try(Connection conn = DriverManager.getConnection(url)) {
                request.setAttribute("mensaje_conexion","ok!");
                String sql = "delete from Clientes where IdCliente='" + IdCliente + "'";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                int registros = pstmt.executeUpdate();
                if (registros > 0){
                    request.getSession().setAttribute("exito", true);
                } else {
                   request.getSession().setAttribute("exito",false);
                }
                
            }
        }catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
        }
    }
 public void agregarProducto(HttpServletRequest request, HttpServletResponse response){
           String IdProducto = request.getParameter("IdProducto");
           String nombreProducto = request.getParameter("nombreProducto");
           String idCategoria = request.getParameter("idCategoria");
           String IdProveedor = request.getParameter("IdProveedor");
           String precio = request.getParameter("precio");
           String categoriaNombre = request.getParameter("categoriaNombre");

           
           
           try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try(Connection conn = DriverManager.getConnection(url)){
                request.setAttribute("mensaje_conexion", "Ok!");
                String sql = "insert into Productos values (?,?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,IdProducto);
                pstmt.setString(2, nombreProducto);
                pstmt.setString(3,idCategoria);
                pstmt.setString(4,IdProveedor);
                pstmt.setString(5, precio);
                pstmt.setString(6, categoriaNombre);
               
                int registros = pstmt.executeUpdate();
                if (registros > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("exito",false);
                }
              }
           
        } catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
      }

} 
 public void ModificarProducto(HttpServletRequest request, HttpServletResponse response){
        
           String IdProducto = request.getParameter("IdProducto");
           String nombreProducto = request.getParameter("nombreProducto");
           String idCategoria = request.getParameter("idCategoria");
           String IdProveedor = request.getParameter("IdProveedor");
           String precio = request.getParameter("precio");
           String categoriaNombre = request.getParameter("categoriaNombre");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url)) {
                request.setAttribute("mensaje_conexion", "Ok!");
                
                String sql = "update Empleados set "
                 + "nombreProducto='"+nombreProducto+"', "
                 + "idCategoria='"+idCategoria+"', "
                 + "IdProveedor='"+IdProveedor+"', "
                 + "precio='"+precio+"', "
                 + "categoriaNombre='"+categoriaNombre+"', ";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                int registros = pstmt.executeUpdate();
                if (registros > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("exito", false);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
        }
    
    }
 public void eliminarproducto(HttpServletRequest request, HttpServletResponse response){
        String  IdProducto = request.getParameter("IdProducto");
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try(Connection conn = DriverManager.getConnection(url)) {
                request.setAttribute("mensaje_conexion","ok!");
                String sql = "delete from Productos where IdProducto='" + IdProducto + "'";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                int registros = pstmt.executeUpdate();
                if (registros > 0){
                    request.getSession().setAttribute("exito", true);
                } else {
                   request.getSession().setAttribute("exito",false);
                }
                
            }
        }catch (SQLException | ClassNotFoundException ex) {
            request.getSession().setAttribute("exito", false);
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String  accion = request.getParameter("accion");
        if(accion == null){
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        }else if (accion.equals("Login")){
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        }else if (accion.equals("GestionarEmpleados")){
            mostrarEmpleados(request, response);
            request.getRequestDispatcher("/OpcionesUsuario/GestionarEmpleados.jsp").forward(request,response);
        }else if (accion.equals("GestionarProductos")){
            mostrarProductos(request, response);
            request.getRequestDispatcher("/OpcionesUsuario/GestionarProductos.jsp").forward(request,response);
        }else if (accion.equals("GestionarProveedor")){
            MostrarProveedores(request, response);
            request.getRequestDispatcher("/OpcionesUsuario/GestionarProveedor.jsp").forward(request,response);
        }else if (accion.equals("GestionarFacturas")){
            MostrarFacturas(request, response);
            request.getRequestDispatcher("/OpcionesUsuario/GestionarFacturas.jsp").forward(request,response);
        }else if (accion.equals("GestionarUsuarios")){
            MostrarUsuarios(request, response);
            request.getRequestDispatcher("/OpcionesUsuario/GestionarUsuarios.jsp").forward(request,response);
        }else if (accion.equals("GestionarCategorias")){
            MostarCategorias(request, response);
            request.getRequestDispatcher("/OpcionesUsuario/GestionarCategorias.jsp").forward(request,response);
        }else if (accion.equals("GestionarAsignacionRolesOpciones")){
            MostrarAsigancionRolesOpciones(request, response);
            request.getRequestDispatcher("/OpcionesUsuario/GestionarAsignacionRolesOpciones.jsp").forward(request,response);
        }else if (accion.equals("GestionarClientes")){
            MostrarClientes(request, response);
            request.getRequestDispatcher("/OpcionesUsuario/GestionarClientes.jsp").forward(request,response);
        }else if (accion.equals("AgregarEmpleado")) {
            if (request.getSession().getAttribute("exito") != null) {
                request.setAttribute("exito", request.getSession().getAttribute("exito"));
                request.getSession().removeAttribute("exito");
            }
            request.getRequestDispatcher("OpcionesUsuario/AgregarEmpleado.jsp").forward(request, response);
        }else if (accion.equals("AgregarCliente")) {
            if (request.getSession().getAttribute("exito") != null) {
                request.setAttribute("exito", request.getSession().getAttribute("exito"));
                request.getSession().removeAttribute("exito");
            }
            request.getRequestDispatcher("/OpcionesUsuario/GestionarEmpleados.jsp").forward(request, response);
        }else if (accion.equals("AgregarProducto")) {
            if (request.getSession().getAttribute("exito") != null) {
                request.setAttribute("exito", request.getSession().getAttribute("exito"));
                request.getSession().removeAttribute("exito");
            }
            request.getRequestDispatcher("OpcionesUsuario/AgregarProducto.jsp").forward(request, response);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String accion = request.getParameter("accion");
        
        if (accion.equals("Login")){
            String usuario = request.getParameter("tfUsuario");
            String contrasenia = request.getParameter("tfContrasenia");
            
        try(PrintWriter print = response.getWriter()){
                if(usuario.equals("admin") && contrasenia.equals("root")) {
                    request.getRequestDispatcher("/PanelAdministrador.jsp").forward(request, response);
                }if(usuario.equals("gerente") && contrasenia.equals("root")) {
                    request.getRequestDispatcher("/PanelAdministrador.jsp").forward(request, response);
                }if(usuario.equals("cajero") && contrasenia.equals("root")) {
                    request.getRequestDispatcher("/PanelAdministrador.jsp").forward(request, response);
                }else {
            
                   print.println("<!DOCTYPE html>");
                   print.println("<html>");
                   print.println("<head>");
                   print.println("<title>Login Sistema Supermercado</title>");
                   print.println("</head>");
                   print.println("<body>");
                   print.println("<h2>Error la contraseña o el usuario son erroneos</h2>");
                   print.println("</body>");
                   print.println("</html>");
                
                }
            }
        
        }
        if (accion.equals("AgregarEmpleado")){
        agregarEmpleado(request, response);
        response.sendRedirect(request.getContextPath()+"/ServletPrincipal?accion=AgregarEmpleado");
        }else if (accion.equals("ModificarEmpleado")) {
            ModificarEmpleado(request,response);
            response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=GestionarEmpleados");
        }else if (accion.equals("EliminarEmpleado")){
            System.out.println("Entro al metodo");
            eliminarEmpleado(request, response);
            System.out.println("Hace el llamado");
            response.sendRedirect(request.getContextPath()+"/ServletPrincipal?accion=GestionarEmpleados");
            
        }
        if (accion.equals("AgregarClientes")){
            System.out.println("Entro al metodo");
        agregarClientes(request, response);
        System.out.println("Hace el llamado");
        response.sendRedirect(request.getContextPath()+"/ServletPrincipal?accion=AgregarCliente");
        }else if (accion.equals("ModificarCliente")) {
            ModificarCliente(request,response);
            response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=GestionarClientes");
        }else if (accion.equals("EliminarCliente")){
            eliminarCliente(request, response);
            response.sendRedirect(request.getContextPath()+"/ServletPrincipal?accion=GestionarClientes");
        }
        
        if (accion.equals("AgregarProducto")){
            System.out.println("Entro al metodo");
        agregarClientes(request, response);
        System.out.println("Hace el llamado");
        response.sendRedirect(request.getContextPath()+"/ServletPrincipal?accion=AgregarProducto");
        }else if (accion.equals("ModificarProducto")) {
        ModificarProducto(request,response);
        response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=GestionarProductos");
        }else if (accion.equals("Eliminarproducto")){
            eliminarproducto(request, response);
            response.sendRedirect(request.getContextPath()+"/ServletPrincipal?accion=GestionarProducto");
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
