package sample;
// intially my graph contains no vertex no edge
//we have to add vertex and edges by user interface provided by this programme
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

class Vertex{
    private String name;
    private int x;
    private int y;

    public Vertex(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
class Edge{
    private String From;
    private String To;
    private int weight;

    public Edge(String from, String to, int weight) {
        From = from;
        To = to;
        this.weight = weight;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
class Graph{
    private ArrayList<Vertex> Vlist;
    private ArrayList<Edge> Alist;

    public Graph() {
        Vlist=new ArrayList<>();
        Alist=new ArrayList<>();
    }

    public ArrayList<Vertex> getVlist() {
        return Vlist;
    }



    public ArrayList<Edge> getAlist() {
        return Alist;
    }

    public void addVertex(String srt1){
        String[] strt=srt1.split(" ");
        try {
            Vertex vi=new Vertex(strt[0],Integer.valueOf(strt[1]),Integer.valueOf(strt[2]));
            Vlist.add(vi);
        }
        catch (Exception ed){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("format: name xpos ypos");
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }

    }
    public void addEdge(String srt1){
        String[] strt=srt1.split(" ");
        try{
        Edge edg=new Edge(strt[0],strt[1],Integer.valueOf(strt[2]));
        Alist.add(edg);}
        catch (Exception ed){
            //System.out.println("kjdjfkn");
            //System.out.println("kjdjfkn");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("format: fromVer toVer Weight ");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();

        }
    }
    public void deleteVertex(String vi) throws Exception {
            boolean f=true;
        for(int i=0;i<50;i++){
        System.out.println("Hello");
        Iterator itt=Alist.listIterator();
        System.out.println("Hello");

        while(itt.hasNext()){
            System.out.println("Hello1");
            Edge e=(Edge) itt.next();
            System.out.println("Hello2");
            if(vi.equals(e.getFrom())){
                System.out.println("Hello3");
               Alist.remove(e);
                break;
                //System.out.println("Hello4");
            }
             else if(vi.equals(e.getTo())){
                System.out.println("Hello5");
               Alist.remove(e);
                break;
               // System.out.println("Hello6");
            }
        }}
        Iterator it=Vlist.listIterator();
        while(it.hasNext()){
            System.out.println("Hello7");
            Vertex ee=(Vertex) it.next();
            if(vi.equals(ee.getName())){
                System.out.println("Hello8");
               f=false;
               Vlist.remove(ee);
                System.out.println("Hello9");
               return;
            }
            //System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
        }
        System.out.println("Hello10");
        if(f){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Vertex not found ");
            alert.setContentText("enter correct value");
            alert.showAndWait();

        }
    }
    public void deleteEdge(String vi) throws Exception{
        String[] str=vi.split(" ");
          boolean f = true;
        Iterator it=Alist.listIterator();
        while(it.hasNext()){
            Edge e=(Edge) it.next();
            if(str[0].equals(e.getFrom())&&str[1].equals(e.getTo())){
               f=false; Alist.remove(e);
               return;
            }
            //System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
        }
        if(f){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Edge not found ");
            alert.setContentText("enter correct value");
            alert.showAndWait();

        }
    }
    public void modifyVertex(String vi){
        String[] str=vi.split(" ");
        boolean f=true;
        try {
            Iterator it = Vlist.listIterator();
            while (it.hasNext()) {
                Vertex e = (Vertex) it.next();
                if (str[0].equals(e.getName())) {
                    e.setName(str[3]);
                    e.setX(Integer.valueOf(str[4]));
                    e.setY(Integer.valueOf(str[5]));
                    f=false;
                }
                //System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
            }
            if(f){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Vertex not found ");
                alert.setContentText("enter correct value");
                alert.showAndWait();

            }
        }
        catch (Exception ed){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("format: name xpos ypos mname mxpos mypost");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();

        }
    }
    public  void modifyEdge(String vi){
        String[] str=vi.split(" ");
        boolean f=true;
       try {
           Iterator it = Alist.listIterator();
           while (it.hasNext()) {
               Edge e = (Edge) it.next();
               if (str[0].equals(e.getFrom()) && str[1].equals(e.getTo())) {
                   e.setFrom(str[3]);
                   e.setTo(str[4]);
                   e.setWeight(Integer.valueOf(str[5]));
                   f=false;
               }
               //System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
           }

             if(f){
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Error ");
                 alert.setHeaderText("format: name xpos ypos mname mxpos mypost");
                 alert.setContentText("Ooops, there was an error!");
                 alert.showAndWait();
             }

       }
       catch (Exception ed){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error ");
           alert.setHeaderText("format: fromVer toVer Weight mfromVer mtoVer mWeight");
           alert.setContentText("Ooops, there was an error!");
           alert.showAndWait();

       }
    }
    public String searchVertex(String vi){
        Iterator it = Vlist.listIterator();
        boolean f =true;
        while(it.hasNext()){
            Vertex e=(Vertex) it.next();
            if(vi.equals(e.getName())){
                f=false; return e.getX()+" "+e.getY(); }
            //System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
        }

        if(f){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Vertex not found ");
            alert.setContentText("enter correct value");
            alert.showAndWait();
        }
        return " ";
    }
    public String searchEdge(String vi) {
        String[] str = vi.split(" ");
        boolean f = true;

        Iterator it = Alist.listIterator();
        while (it.hasNext()) {
            Edge e = (Edge) it.next();
            if (str[0].equals(e.getFrom()) && str[1].equals(e.getTo())) {

                f = false;
                return "weight: " + String.valueOf(e.getWeight());
            }
            //System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
        }


            if (f) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Edge not found ");
                alert.setContentText("enter correct value");
                alert.showAndWait();
            }
            return " ";
        }
       public void importGraph(String vi) throws Exception{
          Vlist.clear();
          Alist.clear();
           File ok= new File("C:\\Users\\Abhinandan\\IdeaProjects\\iit2018187_assignment2\\Java_c3_1\\src\\"+vi);
           if(ok.exists()) {
               Scanner scan = new Scanner(ok);

               // System.out.println("klj");
               String str = scan.nextLine();
               // System.out.println(str);
               int f = Integer.valueOf(str);
               for (int i = 0; i < f; i++) {
                   String srt1 = scan.nextLine();
                   String[] strt = srt1.split(" ");
                   Vertex vii = new Vertex(strt[0], Integer.valueOf(strt[1]), Integer.valueOf(strt[2]));
                   Vlist.add(vii);
               }
               String nedg = scan.nextLine();
               int nedge = Integer.valueOf(nedg);
               for (int i = 0; i < nedge; i++) {
                   String srt1 = scan.nextLine();
                   String[] strt = srt1.split(" ");
                   Edge edg = new Edge(strt[0], strt[1], Integer.valueOf(strt[2]));
                   Alist.add(edg);
               }
           }
       }
       public void exportGraph(String vi) throws Exception {
           File ok = new File("C:\\Users\\Abhinandan\\IdeaProjects\\Java_c3_1\\src\\" + vi);
           ok.createNewFile();
           Collections.sort(Vlist, new SortVertex());
           String str = "";
           str += String.valueOf(Vlist.size()) + "\n";
           Iterator it = Vlist.listIterator();
           boolean f = true;
           while (it.hasNext()) {
               Vertex e = (Vertex) it.next();
               str += e.getName() + " " + String.valueOf(e.getX()) + " " + String.valueOf(e.getY()) + "\n";
               //System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
           }
           str += String.valueOf(Alist.size()) + "\n";
           Iterator itt = Alist.listIterator();
           while (itt.hasNext()) {
               Edge e = (Edge) itt.next();
               str+=e.getFrom()+" "+e.getTo()+" "+String.valueOf(e.getWeight())+"\n";
           }
           BufferedWriter b = new BufferedWriter(new FileWriter(ok));
           b.write(str);
           b.close();

       }
    public void sortGraph(){
        Collections.sort(Alist, new Sortedge());
    }
    public void print(){
        sortGraph();
        Iterator it=Alist.listIterator();
        while(it.hasNext()){
            Edge e=(Edge)it.next();
            System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
        }
    }
    public String rec(int prv, Map<Integer,String> trii,ArrayList<Integer> parenti,String from){
        if(prv==-1)
            return "";
        String str=rec(parenti.get(prv),trii,parenti,from)+" -> "+trii.get(prv);
        return str;

    }
    public String printPath(String vi){
        System.out.println("hello i m in print path");
        sortGraph();
        String[] ft=vi.split(" ");
        Map<Integer,String> tr = new TreeMap<>();
        Map<String,Integer> tri=new TreeMap<>();
        ArrayList<Integer> dist=new ArrayList<>();
        ArrayList<Integer> parent=new ArrayList<>();
        ArrayList<Boolean> vis=new ArrayList<>();
        Iterator it = Vlist.listIterator();
        int ii=0;
        while(it.hasNext()){
            Vertex vh=(Vertex)it.next();
            dist.add(40000);
            parent.add(-1);
            vis.add(true);
            tr.put(ii,vh.getName());
            tri.put(vh.getName(),ii);
            ii++;
        }
        String  from=ft[0];
        String  to=ft[1];
        dist.set(tri.get(from),0);
        for(int i=0;i<Vlist.size();i++){
            int min=40000,minid=-1;
            for(int iik=0;iik<Vlist.size();iik++){
                if(min>dist.get(iik)&&vis.get(iik)){
                    min=dist.get(iik);
                    minid = iik;
                }

            }
            Iterator itt = Alist.listIterator();
            while(itt.hasNext()){
                Edge ed= (Edge)itt.next();
                if(minid==tri.get(ed.getFrom())&& vis.get(minid)){
                    if(dist.get(minid)+ed.getWeight()<dist.get(tri.get(ed.getTo()))&&vis.get(tri.get(ed.getFrom()))) {
                        dist.set(tri.get(ed.getTo()), dist.get(minid) + ed.getWeight());
                        parent.set(tri.get(ed.getTo()),minid);
                    }
                }
            }
            vis.set(minid,false);
        }
//        for(int i=0;i<Vlist.size();i++){
//            System.out.println(dist.get(i));
//        }
        if(dist.get(tri.get(to))==40000){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("no path found ");
            alert.setContentText("enter again");
            alert.showAndWait();
            return "";
        }
        String str="";
        int prv=tri.get(to);

         str=rec(prv,tr,parent,from);
        return str;
    }
}
class Sortedge implements Comparator<Edge> {
    public int compare(Edge edg1, Edge edg2) {
        if (edg1.getFrom().equals(edg2.getFrom()))
            return edg1.getTo().compareTo(edg2.getTo());
        else
            return edg1.getFrom().compareTo(edg2.getFrom());
    }
}
class SortVertex implements Comparator<Vertex> {
    public int compare(Vertex edg1, Vertex edg2) {

        return edg1.getName().compareTo(edg2.getName());
    }
}


    public class Main extends Application {
        public static Graph gr = new Graph();


        @Override
        public void start(Stage primaryStage) throws Exception {
            //Parenstat root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            //Graph gr=new Graph();
            primaryStage.setTitle("Hello World");
            TextField b = new TextField("");
            //b.setAlignment(Pos.CENTER);
            TextField c = new TextField("");
            //c.setAlignment(Pos.TOP_LEFT);
            TextField d = new TextField("");
            //d.setAlignment(Pos.TOP_RIGHT);
            TextField a1 = new TextField("");
            TextField a2 = new TextField("");
            TextField a3 = new TextField("");
            TextField a4 = new TextField("");
            TextField a5 = new TextField("");
            TextField a6 = new TextField("");
            TextField a7=new TextField("");
            TextField a8= new TextField("");
            TextField a9=new TextField("");
           // TextField a10=new TextField("");
            TextArea a10=new TextArea("");


            VBox dr=new VBox();
            // create a tile pane
            TilePane r = new TilePane();


            // create a label
            Label l1 = new Label("add Vertex");
            Label l2 = new Label("add Edge");
            Label l3 = new Label("type anything to print graph");
            Label l4 = new Label("delete Vertex");
            Label l5 = new Label("delete Edge");
            Label l6 = new Label("modify Vertex");
            Label l7 = new Label("modify edge");
            Label l8 = new Label("Search Vertex");
            Label l9 = new Label("Search edge");
            Label l10= new Label("import graph");
            Label l11=new Label("export graph");
            Label l12=new Label(" print path");
            Label l13= new Label("output console");
            // Label l4=new Label();

            b.setOnAction(e->{gr.addVertex(b.getText());
                b.clear();});

            c.setOnAction(e->{gr.addEdge(c.getText());
                c.clear();});

            d.setOnAction(e->{ System.out.println("printing graph");
                gr.print();
                d.clear();
            });

            a1.setOnAction(e->{try{
                gr.deleteVertex(a1.getText());
                a1.clear();//l.setText(b.getText());
            }
            catch(Exception es){
                System.out.println("deleted");
            }});

            a2.setOnAction(e->{try{
                gr.deleteEdge(a2.getText());
                a2.clear();//l.setText(b.getText());
            }
            catch (Exception es){
                System.out.println("deleted");
            }});

            a3.setOnAction(e->{gr.modifyVertex(a3.getText());
                a3.clear();
            });
            EventHandler<ActionEvent> event7 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    gr.modifyEdge(a4.getText());
                    a4.clear();//l.setText(b.getText());
                }
            };
            a4.setOnAction(e->{gr.modifyEdge(a4.getText());
                a4.clear();
            });

            a5.setOnAction(e->{String df = gr.searchVertex(a5.getText());
                a5.clear();//l.setText(b.getText());
                a10.setText(df);});

            a6.setOnAction(e->{String gg = gr.searchEdge(a6.getText());
                a6.clear();//l.setText(b.getText());
                a10.setText(gg);});

            a7.setOnAction(e->{try {
                gr.importGraph(a7.getText());
                a7.clear();
            }//l.setText(b.getText());
            //a6.setText(gg);
            catch (Exception e1){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(" wrong input format ");
                alert.setContentText("enter correct value");
                alert.showAndWait();
            }});

            a8.setOnAction(e->{try {
                gr.exportGraph(a8.getText());
                a8.clear();//l.setText(b.getText());
                // a6.setText(gg);
            }
            catch (Exception e2){
                System.out.println("error");
            }});

            a9.setOnAction(e->{
                try {
                    String gh= gr.printPath(a9.getText());
                    a9.clear();
                    a10.setText(gh);
                    //l.setText(b.getText());
                    // a6.setText(gg);
                }
                catch (Exception e2){
                    e2.printStackTrace();
                }
            });
            // add textfield
            r.setHgap(10);
            r.setVgap(10);
            //r.setAlignment(Pos.TOP_LEFT);
            r.getChildren().add(b);
            r.getChildren().add(l1);
            r.getChildren().add(c);
            r.getChildren().add(l2);
            r.getChildren().add(d);
            r.getChildren().add(l3);
            r.getChildren().add(a1);
            r.getChildren().add(l4);
            r.getChildren().add(a2);
            r.getChildren().add(l5);
            r.getChildren().add(a3);
            r.getChildren().add(l6);
            r.getChildren().add(a4);
            r.getChildren().add(l7);
            r.getChildren().add(a5);
            r.getChildren().add(l8);
            r.getChildren().add(a6);
            r.getChildren().add(l9);
            r.getChildren().add(a7);
            r.getChildren().add(l10);
            r.getChildren().add(a8);
            r.getChildren().add(l11);
            r.getChildren().add(a9);
            r.getChildren().add(l12);
           // r.getChildren().add(a10);
           // r.getChildren().add(l13);
            //gf.getChildren().add(a10);
            dr.getChildren().addAll(r,l13,a10);
            primaryStage.setScene(new Scene(dr, 1000, 400));
            primaryStage.show();
        }


        public static void main(String[] args) throws Exception {
            // gr.sortGraph();
            //  System.out.println("jkjg");
            File ok = new File("C:\\Users\\Abhinandan\\IdeaProjects\\Java_c3_1\\src\\IInput.txt");
            if (ok.exists()) {
                Scanner scan = new Scanner(ok);

                // System.out.println("klj");
                String str = scan.nextLine();
                // System.out.println(str);
                int f = Integer.valueOf(str);
                for (int i = 0; i < f; i++) {
                    String srt1 = scan.nextLine();
                    String[] strt = srt1.split(" ");
                    Vertex vi = new Vertex(strt[0], Integer.valueOf(strt[1]), Integer.valueOf(strt[2]));
                    gr.getVlist().add(vi);
                }
                String nedg = scan.nextLine();
                int nedge = Integer.valueOf(nedg);
                for (int i = 0; i < nedge; i++) {
                    String srt1 = scan.nextLine();
                    String[] strt = srt1.split(" ");
                    Edge edg = new Edge(strt[0], strt[1], Integer.valueOf(strt[2]));
                    gr.getAlist().add(edg);
                }
            }
            //gr.printPath("A C");
            launch(args);
        }
    }



