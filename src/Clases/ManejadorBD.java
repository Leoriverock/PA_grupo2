package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorBD {
    
    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String bd = "jdbc:mysql://192.168.56.101:3306/grupo2";
    private final static String usuario = "grupo2";
    private final static String password = "pa2012";
    
    private Connection conexion;
    private java.sql.Statement st;
    
    private static ManejadorBD instancia = null;
    
    public static ManejadorBD getInstancia(){
        if(instancia == null){
            instancia = new ManejadorBD();
        }
        return instancia;
    }
    ////////////////////////////// se establece la conexion ///////////////////////////
    private ManejadorBD() {
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(bd, usuario, password);
            st = conexion.createStatement();
            System.out.println("Conexion exitosa");
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////
    public java.sql.Statement getStatement(){
        return st;
    }
    
    public Object ObtenerIdEquipo(String Nombre)
    {
        ResultSet res;
        try {
            res = st.executeQuery("select ID_Equipos from equipos where Nombre='"+Nombre+"'");
            while(res.next())
            {                
                return res.getObject(1);                
            }
            return null;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    public List ObtenerJugadores(String Equipo, String Partido)
    {
        Equipo=this.ObtenerIdEquipo(Equipo).toString();
        ResultSet res;
        List Lista = new ArrayList();
        try {
            res = st.executeQuery("select NombreCompleto from jugadores, partidos, jugador_partido where jugadores.ID_Jugador=jugador_partido.ID_Jugador and jugador_partido.ID_Partido=partidos.ID_Partido and jugador_partido.ID_Partido='"+Partido+"' and ID_Equipo='"+Equipo+"'");
            while(res.next())
            {                
                Lista.add(res.getObject(1));                
            }
            return Lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public List ListaCompeticion()
    {
        ResultSet res;
        List Lista = new ArrayList();
        try {
            res = st.executeQuery("select ID_Competicion,Nombre,Anio,Tipo from competiciones");
            //return res;
            while(res.next())
            {                
                Lista.add(res.getObject(1));
                Lista.add(res.getObject(2));
                Lista.add(res.getObject(3));
                Lista.add(res.getObject(4));
            }
            return Lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public List ObtenerTodoPartidosVerCompeticion(String nombre)
    {
        List Lista = new ArrayList();
        List Nueva = new ArrayList();
        Lista=this.ObtenerPartidosVerCompeticion(nombre);
        int cont=0;
        for(int i=0; i < Lista.size()/12;i++)
        {
                   
            Nueva.add(this.BuscarNombreEquipo(Integer.valueOf(Lista.get(i*12).toString())));
            Nueva.add(this.BuscarNombreEquipo(Integer.valueOf(Lista.get((i*12)+1).toString())));
            Nueva.add(Lista.get((i*12)+2));
            Nueva.add(Lista.get((i*12)+3));
            Nueva.add(Lista.get((i*12)+4));
            Nueva.add(Lista.get((i*12)+5));
            Nueva.add(Lista.get((i*12)+6));
            Nueva.add(Lista.get((i*12)+7));
            Nueva.add(Lista.get((i*12)+8));
            Nueva.add(Lista.get((i*12)+9));
            Nueva.add(Lista.get((i*12)+10));
            Nueva.add(Lista.get((i*12)+11));          
                                
            
        }
        return Nueva;
    }
    
    public List ObtenerPartidosVerCompeticion(String nombre){
        ResultSet res;
        List Lista = new ArrayList();
        try {
            res = st.executeQuery("select EquipoLocal,EquipoVisita,Fecha,ID_Partido,Goles_Local,Goles_Visitante,DivLocal,DivVisita,DivEmpate,Finalizado,Lugar,Hora from partidos,competiciones where partidos.ID_Comp=competiciones.ID_Competicion and competiciones.Nombre='"+nombre+"' order by Fecha");
            //return res;
            while(res.next())
            {                
                Lista.add(res.getObject(1)); //EquipoLocal
                Lista.add(res.getObject(2)); //EquipoVisita
                Lista.add(res.getObject(3)); //Fecha
                Lista.add(res.getObject(4)); //ID_Partido
                Lista.add(res.getObject(5)); //Goles_Local
                Lista.add(res.getObject(6)); //Goles_Visitante
                Lista.add(res.getObject(7)); //DivLocal
                Lista.add(res.getObject(8)); //DivVisita
                Lista.add(res.getObject(9)); //DivEmpate
                Lista.add(res.getObject(10));  //Finalizado   
                Lista.add(res.getObject(11));  //Lugar
                Lista.add(res.getObject(12));  //Hora                
                
                
            }
            return Lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        
    }
    public List ObtenerDatosCompeticion(Object nombre)
    {
        
        List Lista=new ArrayList();
        ResultSet res;
        try {
            res = st.executeQuery("select Nombre,Anio,Tipo,ID_Competicion from competiciones where Nombre='"+nombre+"'");
            while(res.next())
            {
                Lista.add(res.getObject(1));
                Lista.add(res.getObject(2));
                Lista.add(res.getObject(3));
                Lista.add(res.getObject(4));
            }
            return Lista;
        }
         catch (SQLException ex) {
            System.out.println(ex.toString());
            System.out.println("Error");
            return null;
         }
    }
    public List ListarPartidosCompeticion2(String nombre){
               
        List Lista = new ArrayList();
        List Nueva = new ArrayList();
        
        Lista=this.ObtenerPartidosCompeticion(nombre);
        
        for(int i=0; i < Lista.size(); i++){
            
            Nueva.add(this.BuscarNombreEquipo((Integer)Lista.get(i)));
            i++;
            Nueva.add(this.BuscarNombreEquipo((Integer)Lista.get(i)));            
            i++;
            Nueva.add(Lista.get(i));
            i++;
            Nueva.add(Lista.get(i));
            i++;
            Nueva.add(Lista.get(i));
            i++;
            Nueva.add(Lista.get(i));
        }
        System.out.println("Exito 2");
        return Nueva;
        }
    
    
    
    public void insertEquipo(Equipo equipo){
        
        String nombre = equipo.getNombre();
        int id_generado;
        try {
            int res = st.executeUpdate("insert into equipos (Nombre) values ('"+nombre+"')");
            ResultSet max_id = st.executeQuery("select max(ID_Equipos) from equipos");
            max_id.next();
            id_generado = max_id.getInt(1);
            equipo.setId(id_generado);
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public int insertPartido(int id_l, int id_v, int id_c){
        int id_generado;
        try {
            st.executeUpdate("insert into partidos (ID_comp, EquipoLocal, EquipoVisita) values("+id_c+","+id_l+","+id_v+")");
            ResultSet max_id = st.executeQuery("select max(ID_Partido) from partidos");
            max_id.next();
            id_generado = max_id.getInt(1);
            return id_generado;
            
        } catch (SQLException e) {
            System.out.println("errorpartido"+e.toString());
            return 0;
        }
    }
    
    public int insertCompeticion(String nom, String tipo){
        int id_generado;
        try{
            st.executeUpdate("insert into competiciones (Nombre, Tipo) values ('"+nom+"','"+tipo+"')");
            ResultSet max_id = st.executeQuery("select max(ID_Competicion) from competiciones");
            max_id.next();
            id_generado = max_id.getInt(1);
            return id_generado;
        } catch (SQLException e){
            System.out.println("errorcompeticion"+e.toString());
            return 0;
        }
    }
    
    public int insertJugador(Jugador j){
        int id_generado;
        try {
            String nombre = j.getNombre(), nom_completo = j.getNombre_completo();
            String lugar_nac = j.getNacionalidad(), posicion = j.getPosicion(), fecha_nac = j.getF_nac().DateToString();
            Double altura = j.getAltura(), peso = j.getPeso();
            
            String consulta = "insert into jugadores (nombre, nombreCompleto, fecha_nacimiento, posicion, nacionalidad, altura, peso) "+
                              "values ('"+nombre+"', '"+nom_completo+"', '"+fecha_nac+"',"+
                              " '"+posicion+"', '"+lugar_nac+"', '"+altura+"', '"+peso+"')";
            
            st.executeUpdate(consulta);
            ResultSet max_id = st.executeQuery("select max(id_jugador) from jugadores");
            max_id.next();
            id_generado = max_id.getInt(1);
            return id_generado;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return 0;
        }
    }
    
    public ResultSet selectJugador(Integer id){
        ResultSet res;
        try {
            res = st.executeQuery("select * from jugadores where ID_Jugador='"+id+"'");
            return res;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public ResultSet selectEquipo(int id){
        ResultSet res;
        try {
            res = st.executeQuery("select * from equipos where ID_Equipos ="+id+"");
            return res;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public ResultSet selectLigas(){
        ResultSet res;
        try {
            res = st.executeQuery("SELECT distinct  c.* from competiciones c, partidos p WHERE c.tipo like '%liga%'  and  p.lugar is null");
            return res;
        } catch (SQLException ex) {
             System.out.println(ex.toString());
              return null;
        }
    }
    
    public ResultSet selectPartidosNoFinalizados(Integer id){
        ResultSet res;
        try {
            res = st.executeQuery("SELECT * FROM equipos e1, equipos e2,partidos p, competiciones c WHERE c.id_competicion = "+id+" and c.id_competicion = p.id_comp and finalizado = '0' and p.equipolocal = e1.id_equipos and p.equipovisita = e2.id_equipos and p.lugar is null");
            return res;
        } catch (SQLException ex) {
             System.out.println("No se pudo realizar la consulta"+ex.toString());
              return null;
        }
    }
    public ResultSet selectPartidos(Integer id){
        ResultSet retorno;
        try {
            retorno = st.executeQuery("select * from partidos p, equipos e1, equipos e2 where ID_Partido='"+id+"' and p.lugar is null  and p.equipolocal = e1.id_equipos and p.equipovisita = e2.id_equipos");
            return retorno;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
            return null;
        }
    }
    public void asignarDividendo(int id, double local, double visita, double empate){
        try {
            st.executeUpdate("UPDATE partidos set divlocal = "+local+", divvisita = "+visita+", divempate = "+empate+" where id_partido = "+id+" ");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }
    }
    
    public ResultSet dividendos(){
     ResultSet retorno;
        try {
            retorno = st.executeQuery("select * from partidos p, equipos e, equipos e1 where p.Equipolocal = e.ID_equipos and p.equipovisita = e1.id_equipos and divlocal ='0' and divvisita ='0' and finalizado = '0'order by fecha");
            return retorno;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet selectJugadoresEquipo(int id){
        ResultSet retorno;
        try{
            String consulta = "select distinct j.nombreCompleto from jugadores j, jugador_partido jp"+
                              " where jp.id_equipo = "+id+" and j.id_jugador = jp.id_jugador";
        
            retorno = st.executeQuery(consulta);
            return retorno;
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public void insertEquiposALiga(int id_c, List <Integer> ids, List <Double> dividendos){
        try{
            for (int i=0; i<ids.size(); i++){
            st.executeUpdate("insert into liga_equipo (ID_Liga, ID_Equipo, Dividendo) values ("+id_c+","+ids.get(i)+","+dividendos.get(i)+")");
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ResultSet selectPartidosCompeticion(int id_c){
     ResultSet retorno;
        try {
            retorno = st.executeQuery("select * from partidos p, equipos e, equipos e1 where id_comp="+id_c+" and p.Equipolocal = e.ID_equipos and p.equipovisita = e1.id_equipos order by fecha");
            return retorno;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public List ListarPartidosCompeticion(String nombre){
               
        List Lista = new ArrayList();
        List Nueva = new ArrayList();
        
        Lista=this.ObtenerPartidosCompeticion(nombre);
        
        for(int i=0; i < Lista.size(); i++){
            
            Nueva.add(this.BuscarNombreEquipo((Integer)Lista.get(i)));
            i++;
            Nueva.add(this.BuscarNombreEquipo((Integer)Lista.get(i)));            
            i++;
            Nueva.add(Lista.get(i));
            i++;
            Nueva.add(Lista.get(i));
            i++;
            Nueva.add(Lista.get(i));
            i++;
            Nueva.add(Lista.get(i));
        }
        
        return Nueva;
        }

    public List ObtenerPartidosCompeticion(String nombre){
        ResultSet res;
        List Lista = new ArrayList();
        try {
            res = st.executeQuery("select EquipoLocal,EquipoVisita,Fecha,Hora,Lugar,ID_Partido from partidos,competiciones where partidos.Id_Comp=competiciones.ID_Competicion and competiciones.Nombre='"+nombre+"'and partidos.divlocal>0 and partidos.finalizado=0 order by fecha");
           
            while(res.next()){                
                Lista.add(res.getObject(1));
                Lista.add(res.getObject(2));
                Lista.add(res.getObject(3));
                Lista.add(res.getObject(4));
                Lista.add(res.getObject(5));
                Lista.add(res.getObject(6));
            }                        
            return Lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public List ObtenerJugador(String nombre){
        ResultSet res;
        List Lista = new ArrayList();
        try {
            res = st.executeQuery("select NombreCompleto from equipos, jugadores_equipos,jugadores where equipos.ID_Equipos=jugadores_equipos.Equipo and jugadores.ID_Jugador=jugadores_equipos.Jugador and equipos.Nombre='"+nombre+"'");
            
            while(res.next())
            {                
                Lista.add(res.getObject("NombreCompleto"));                
            }
            return Lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            System.out.println("Error"+ex.toString());
            return null;
        }
    }

    public void AgregarFinalizarPartido(int glocal, int gvisitante, List LocalJugadores,List VisJugadores,String Id)
    {
        String local;
        String vis;
        List JugadoresL=new ArrayList();
        List JugadoresV=new ArrayList();
        local=this.ObtenerIdEquipoL(Id);
        vis=this.ObtenerIdEquipoV(Id);
        
        JugadoresL=this.ObtenerListaIDJugador(LocalJugadores);
        JugadoresV=this.ObtenerListaIDJugador(VisJugadores);
        
        this.AgregarLVPartido(JugadoresL, JugadoresV, Id, local, vis);
        
        this.AgregarGoles(glocal, gvisitante, Id);
        
    }
    
    public String ObtenerIdEquipoL(String Id)
    {       
        ResultSet res;
        try{
        res = st.executeQuery("select EquipoLocal from partidos where ID_Partido='"+Id+"'");
            while(res.next())
            {
                return String.valueOf((Integer)res.getObject(1));
            }
        }
        
        
         catch (SQLException ex) {
             System.out.println(ex.toString());
             System.out.println("Error");
             
         }
        return null;
    }
    
    public String ObtenerIdEquipoV(String Id)
    {       
        ResultSet res;
        try{
            System.out.println("Exito 3");
            
        
        res = st.executeQuery("select EquipoVisita from partidos where ID_Partido='"+Id+"'");
            while(res.next())
            {
                return String.valueOf((Integer)res.getObject(1));
            }
        }
        
        
         catch (SQLException ex) {
             System.out.println(ex.toString());
             System.out.println("Error");
             
         }
        return null;
    }
    
    

    public List ObtenerListaIDJugador(List Jugador)
    {
        List Nuevo=new ArrayList();
        for(int i=0;i<Jugador.size();i++)
        {
            Nuevo.add(this.ObtenerIDJugador(Jugador.get(i)));
        }
        return Nuevo;
    }
    public Object ObtenerIDJugador(Object nombre){
        ResultSet res;
        try {
            res = st.executeQuery("select ID_Jugador from jugadores where NombreCompleto='"+nombre+"'");
            while(res.next())
            {
                return res.getObject(1);
            }
            return null;
        }
         catch (SQLException ex) {
             System.out.println(ex.toString());
             System.out.println("Error");
             return null; 
         }
    }
    
    public void AgregarLVPartido(List LocalJugadores,List VisJugadores, String Id, String Local, String Vis){
        try{
            
            for(int i=0;i<LocalJugadores.size();i++){                
                st.executeUpdate("insert into jugador_partido (ID_Partido, ID_Jugador, ID_Equipo) values ('"+Id+"','"+LocalJugadores.get(i)+"','"+Local+"')");
            }
            
            for(int i=0;i<LocalJugadores.size();i++){
                st.executeUpdate("insert into jugador_partido (ID_Partido, ID_Jugador, ID_Equipo) values ('"+Id+"','"+VisJugadores.get(i)+"','"+Vis+"')");
            }
            
            
        } catch (SQLException e){
            System.out.println("errorcompeticion"+e.toString());
           
        }
    } 
     
    public void AgregarGoles(int glocal, int gvisitante, String id){
        try {
            st.executeUpdate("update partidos set Goles_Local = "+glocal+", Goles_Visitante = "+gvisitante+" where ID_Partido = "+id+" ");
            st.executeUpdate("update partidos set finalizado=1 where ID_Partido = "+id+" ");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }
    }
    
     public Object BuscarNombreEquipo(int nombre){
        ResultSet res;        
        try {
            res = st.executeQuery("select Nombre from equipos where ID_Equipos="+nombre+"");
            while(res.next()){
                return res.getObject(1);
            }
            return null;
        }
         catch (SQLException ex) {
            System.out.println(ex.toString());
            System.out.println("Error");
            return null;
        }
     }
     
     public void setPartidoIndividual(int id_c, String hora, Date fecha, String lugar){
        try {
            
            st.executeUpdate("update partidos set Hora='"+hora+"', Fecha='"+fecha.DateToString()+"', Lugar='"+lugar+"' where ID_Comp="+id_c+" ");
        } catch (SQLException ex) {
            System.out.println("error consulta "+ex.toString());
        }
    }
     public void PartidoLiga(int id_c, String hora, Date fecha, String lugar,String id_p){
        try {
            int id = Integer.parseInt(id_p);
            st.executeUpdate("UPDATE partidos set hora = '"+hora+"', fecha='"+fecha.DateToString()+"', Lugar = '"+lugar+"' WHERE ID_Comp = "+id_c+" and id_partido = "+id+"");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }
     }
     
     public void modificarJugador(Jugador j){
        try {
            String nombre = j.getNombre(), nom_completo = j.getNombre_completo();
            String lugar_nac = j.getNacionalidad(), posicion = j.getPosicion(), fecha_nac = j.getF_nac().DateToString();
            Double altura = j.getAltura(), peso = j.getPeso();
            int id= j.getId();
            System.out.println(id);
            String consulta = "update  jugadores  set nombre = '"+nombre+"', nombreCompleto= '"+nom_completo+
                    "' , fecha_nacimiento='"+fecha_nac+"' , nacionalidad= '"+lugar_nac+"' , posicion='"+posicion+
                    "' , altura='"+altura+"' , peso='"+peso+"' where id_jugador="+j.getId()+"";
            
            st.executeUpdate(consulta);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
     
     public void InsertarFechaHora(int dia,int mes,int anio, int hora,int minuto){
     try {
            st.executeUpdate("UPDATE Fecha set Dia = "+dia+", Mes = "+mes+", año = "+anio+", Hora= "+hora+", Minuto="+minuto+" where ID = 1");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }
    }

public List ObtenerFechaHora()
    {
        ResultSet res;
        List Lista= new ArrayList();
         try {
            res = st.executeQuery("select * from fecha where Id=1");
            while(res.next())
            {         
                Lista.add(res.getObject(1));
                Lista.add(res.getObject(2));
                Lista.add(res.getObject(3));
                Lista.add(res.getObject(4));
                Lista.add(res.getObject(5));              
            }
            return Lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        
    }
     
     public void cargarDatosDePrueba(){
        //JUGADORES
        try{
            
            //jugador 1
            Jugador j1 = new Jugador("Tony Stark");
            j1.setNombre("Iron Man");
            j1.setPosicion("forward");
            j1.setF_nac(new Date(3,12,1981));
            j1.setNacionalidad("USA");
            j1.setAltura(1.70);
            j1.setPeso(80);
            instancia.insertJugador(j1);
            
            //jugador 2
            Jugador j2 = new Jugador("Colonel Nick Fury");
            j2.setNombre("Nick Fury");
            j2.setPosicion("defender");
            j2.setF_nac(new Date(22,8,1961));
            j2.setNacionalidad("USA");
            j2.setAltura(1.80);
            j2.setPeso(80);
            instancia.insertJugador(j2);
            
            //jugador 3
            Jugador j3 = new Jugador("Bruce Banner");
            j3.setNombre("The Hulk");
            j3.setPosicion("forward");
            j3.setF_nac(new Date(15,3,1980));
            j3.setNacionalidad("USA");
            j3.setAltura(2.06);
            j3.setPeso(120);
            instancia.insertJugador(j3);
            
            //jugador 4
            Jugador j4 = new Jugador("Panthro");
            j4.setNombre("Panthro");
            j4.setPosicion("defender");
            j4.setF_nac(new Date(12,10,1963));
            j4.setNacionalidad("Thundera");
            j4.setAltura(2.00);
            j4.setPeso(100);
            instancia.insertJugador(j4);
            
            //jugador 5
            Jugador j5 = new Jugador("Logan");
            j5.setNombre("Wolverine");
            j5.setPosicion("forward");
            j5.setF_nac(new Date(3,11,1980));
            j5.setNacionalidad("USA");
            j5.setAltura(1.80);
            j5.setPeso(80);
            instancia.insertJugador(j5);
            
            //jugador 6
            Jugador j6 = new Jugador("Laurie Juspeczyk");
            j6.setNombre("Silk Spectre");
            j6.setPosicion("defender");
            j6.setF_nac(new Date(11,9,1984));
            j6.setNacionalidad("USA");
            j6.setAltura(1.76);
            j6.setPeso(72);
            instancia.insertJugador(j6);
            
            //jugador 7
            Jugador j7 = new Jugador("Bruce Wayne");
            j7.setNombre("Batman");
            j7.setPosicion("defender");
            j7.setF_nac(new Date(21,3,1977));
            j7.setNacionalidad("USA");
            j7.setAltura(1.78);
            j7.setPeso(80);
            instancia.insertJugador(j7);
            
            //jugador 5
            Jugador j8 = new Jugador("Harold Jordan");
            j8.setNombre("Green Lantern");
            j8.setPosicion("forward");
            j8.setF_nac(new Date(10,3,1980));
            j8.setNacionalidad("USA");
            j8.setAltura(1.90);
            j8.setPeso(80);
            instancia.insertJugador(j8);
            
        } catch (Exception e){
            System.out.println("error jugadores"+e.toString());
        
        }
        
        //EQUIPOS
        try{
            
            Equipo e1 = new Equipo("Thundercats");
            instancia.insertEquipo(e1);
            
            Equipo e2 = new Equipo("Avengers");
            instancia.insertEquipo(e2);
            
            Equipo e3 = new Equipo("X-Mens");
            instancia.insertEquipo(e3);
            
            Equipo e4 = new Equipo("S.H.I.E.L.D.");
            instancia.insertEquipo(e4);
            
            Equipo e8 = new Equipo("Green Lantern Corps");
            instancia.insertEquipo(e8);
            
            Equipo e5 = new Equipo("Justice League");
            instancia.insertEquipo(e5);
            
            Equipo e6 = new Equipo("Watchmen");
            instancia.insertEquipo(e6);
            
            Equipo e7 = new Equipo("Future Foundation");
            instancia.insertEquipo(e7);
            
        } catch(Exception e){
            System.out.println("error equipos"+e.toString());
        }
        
        //COMPETICIONES
        try{
            //comp1
            instancia.insertCompeticion("Fabs. Match", "Individual");
            int id_l1=0;
            int id_v1=0; 
            int id_c1=0;
            ResultSet res1 = st.executeQuery("select distinct * from equipos el, equipos ev, competiciones c where el.nombre='Watchmen' and ev.nombre='Avengers' and c.nombre='Fabs. Match'");
            while(res1.next()){
                id_l1= Integer.parseInt(res1.getObject("el.id_equipos").toString());
                id_v1= Integer.parseInt(res1.getObject("ev.id_equipos").toString());
                id_c1= Integer.parseInt(res1.getObject("c.id_competicion").toString());
            }
            if (id_l1 == 0 || id_v1 == 0 || id_c1 == 0){
                System.out.println("Error comp1");
            } else {
                int id_p1 = instancia.insertPartido(id_l1, id_v1, id_c1);
                instancia.asignarDividendo(id_p1, 2.1, 1.3, 1.2);
                instancia.getStatement().executeUpdate("update partidos set finalizado='1' where id_partido = "+id_p1+" ");
                
            }
            
            //comp2
            instancia.insertCompeticion("Marbles Just", "Individual");
            int id_l2=0;
            int id_v2=0; 
            int id_c2=0;
            ResultSet res2 = st.executeQuery("select distinct * from equipos el, equipos ev, competiciones c where el.nombre='S.H.I.E.L.D.' and ev.nombre='Future Foundation' and c.nombre='Marbles Just'");
            while(res2.next()){
                id_l2= Integer.parseInt(res2.getObject("el.id_equipos").toString());
                id_v2= Integer.parseInt(res2.getObject("ev.id_equipos").toString());
                id_c2= Integer.parseInt(res2.getObject("c.id_competicion").toString());
            }
            if (id_l2 == 0 || id_v2 == 0 || id_c2 == 0){
                System.out.println("Error comp2");
            } else {
                int id_p2 = instancia.insertPartido(id_l2, id_v2, id_c2);
                instancia.asignarDividendo(id_p2, 1.1, 3, 2.1);
                
            }
            
            //comp3
            instancia.insertCompeticion("Epic Competition", "Individual");
            int id_l3=0;
            int id_v3=0; 
            int id_c3=0;
            ResultSet res3 = st.executeQuery("select distinct * from equipos el, equipos ev, competiciones c where el.nombre='Green Lantern Corps' and ev.nombre='Justice League' and c.nombre='Epic Competition'");
            while(res3.next()){
                id_l3= Integer.parseInt(res3.getObject("el.id_equipos").toString());
                id_v3= Integer.parseInt(res3.getObject("ev.id_equipos").toString());
                id_c3= Integer.parseInt(res3.getObject("c.id_competicion").toString());
            }
            if (id_l3 == 0 || id_v3 == 0 || id_c3 == 0){
                System.out.println("Error comp3");
            } else {
                int id_p3 = instancia.insertPartido(id_l3, id_v3, id_c3);
                instancia.asignarDividendo(id_p3, 3.1, 1.1, 2.1);
                
            }
            
            //comp4
            instancia.insertCompeticion("Special Cup", "Liga");
            
            List <Integer> ids_eq = new ArrayList<>();
            List <Double> divs = new ArrayList<>();
            int id_c4=0;
            ResultSet res4 = st.executeQuery("select distinct * from equipos e2, equipos e1, equipos e3, equipos e4, competiciones c where e1.nombre='Thundercats' and e2.nombre='Avengers' and e3.nombre='X-Mens' and e4.nombre='S.H.I.E.L.D.' and c.nombre='Special Cup'");
            while(res4.next()){
                ids_eq.add(Integer.parseInt(res4.getObject("e1.id_equipos").toString()));
                ids_eq.add(Integer.parseInt(res4.getObject("e2.id_equipos").toString()));
                ids_eq.add(Integer.parseInt(res4.getObject("e3.id_equipos").toString()));
                ids_eq.add(Integer.parseInt(res4.getObject("e4.id_equipos").toString()));
                id_c4= Integer.parseInt(res4.getObject("c.id_competicion").toString());
            }
            
            
            
            //comp5
            instancia.insertCompeticion("Awesome League", "Liga");
            
            List <Integer> ids_eqs = new ArrayList<>();
            List <Double> div = new ArrayList<>();
            int id_c5=0;
            ResultSet res5 = st.executeQuery("select * from equipos e2, equipos e1, equipos e3, equipos e4, competiciones c where e1.nombre='Green Lantern Corps' and e2.nombre='Justice League' and e3.nombre='Watchmen' and e4.nombre='Future Foundation' and c.nombre='Awesome League'");
            while(res5.next()){
                ids_eqs.add(Integer.parseInt(res5.getObject("e1.id_equipos").toString()));
                ids_eqs.add(Integer.parseInt(res5.getObject("e2.id_equipos").toString()));
                ids_eqs.add(Integer.parseInt(res5.getObject("e3.id_equipos").toString()));
                ids_eqs.add(Integer.parseInt(res5.getObject("e4.id_equipos").toString()));
                id_c5= Integer.parseInt(res5.getObject("c.id_competicion").toString());
            }
            
            
            
        } catch(SQLException e){
            System.out.println("error competiciones"+e.toString());
        }
        
        //PARTIDOS INDIVIDUALES
        try{
        ResultSet res = st.executeQuery("select * from partidos p1, competiciones c where p1.id_comp=c.id_competicion and c.nombre='Fabs. Match'");
        int id1=0;
        while (res.next()){
            id1=res.getInt("c.id_competicion");
        }
        Date f1 = new Date(1,9,2011);
        instancia.setPartidoIndividual(id1, "203000", f1, "Anexo");
        
        
        ResultSet res2 = st.executeQuery("select * from partidos p1, competiciones c where p1.id_comp=c.id_competicion and c.nombre='Marbles Just'");
        int id2=0;
        while (res2.next()){
            id2=res2.getInt("c.id_competicion");
        }
        Date f2 = new Date(11,9,2011);
        instancia.setPartidoIndividual(id2, "203000", f2, "Aulario");
        
        ResultSet res3 = st.executeQuery("select * from partidos p1, competiciones c where p1.id_comp=c.id_competicion and c.nombre='Epic Competition'");
        int id3=0;
        while (res3.next()){
            id3=res3.getInt("c.id_competicion");
        }
        Date f3 = new Date(9,9,2011);
        instancia.setPartidoIndividual(id3, "203000", f3, "2do Piso");
        } catch(SQLException e){
            System.out.println(e.toString());
        }
     }
     public ResultSet ObtenerEquipo(int id){
        try {
            ResultSet re = st.executeQuery("select * from equipos where id_equipos = "+id+"");
            return re;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
            return null;
        }
     }
     public void ActualizarFotoEquipo(String urls, int id){
         try {
            st.executeUpdate("UPDATE equipos set imagen = '"+urls+"' WHERE id_equipos = "+id+"");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }
     
     }
    public List ObtenerRegistro()
     {
         ResultSet res;
        List Lista= new ArrayList();
         try {
            res = st.executeQuery("select Fecha,IP,Cliente,SO from registro");
            while(res.next())
            {         
                Lista.add(res.getObject(1));
                Lista.add(res.getObject(2));
                Lista.add(res.getObject(3));
                Lista.add(res.getObject(4));             
            }
            return Lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
     }
    public void CrearPartidoLiga(int Comp, int Local, int Visita){
        try {
            int res = st.executeUpdate("INSERT INTO partidos (id_comp,equipolocal, equipovisita) VALUES ("+Comp+","+Local+","+Visita+")");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
    }   
    public void CrearPenca(int Comp){
        try {
            int res = st.executeUpdate("INSERT INTO pencas (id_comp) VALUES ("+Comp+")");
        } catch (SQLException ex) {
             System.out.println("Error: "+ex);
        }

    }
    
    
}