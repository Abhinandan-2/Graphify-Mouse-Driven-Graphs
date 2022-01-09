package sample;
// intially my graph contains no vertex no edge
//we have to add vertex and edges by user interface provided by this programme
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

class Vertex{
    private String name;
    private double x;
    private double y;

    public Vertex(String name, double x, double y) {
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
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
            Vertex vi=new Vertex(strt[0],Double.valueOf(strt[1]),Double.valueOf(strt[2]));
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
    public void deleteVertex(String vi) throws Exception{
            boolean f=true;
        Iterator it=Vlist.listIterator();
        while(it.hasNext()){
            Vertex e=(Vertex) it.next();
            if(vi.equals(e.getName())){
               f=false; Vlist.remove(e); return;}
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
                    e.setX(Double.valueOf(str[4]));
                    e.setY(Double.valueOf(str[5]));
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
    public Vertex searchVertex(String vi){
        Iterator it = Vlist.listIterator();
        boolean f =true;
        while(it.hasNext()){
            Vertex e=(Vertex) it.next();
            if(vi.equals(e.getName())){
                f=false; return e; }
            //System.out.println(e.getFrom()+" "+e.getTo()+" "+e.getWeight());
        }

        if(f){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Vertex not found ");
            alert.setContentText("enter correct value");
            alert.showAndWait();
        }
        return new Vertex("",0,0);
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
           File ok= new File("C:\\Users\\Abhinandan\\IdeaProjects\\c2p1\\src\\"+vi);
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
        String str=rec(parenti.get(prv),trii,parenti,from)+" "+trii.get(prv);
        return str;

    }
    public String printPath(String vi){
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

        List<Circle> arcrcl=new ArrayList<>();
        Map<Circle,Vertex> map=new HashMap<>();
        Map<Vertex,Circle> mp=new HashMap<>();
        @Override
        public void start(Stage primaryStage) throws Exception {
            VBox root=new VBox();
            TextField a1=new TextField();
            root.getChildren().addAll(a1,new Label("enter path"));
            Pane pane = new Pane();
            pane.getChildren().add(root);
           // Circle cir=new Circle(8);
            primaryStage.setScene(new Scene(pane, 1000, 400));
            //

            pane.setOnDragDetected(e->{
                System.out.println("hello");
                Circle cir=new Circle(8);
               // Circle cfr=new Circle(8);
                double x=e.getX();
                double y=e.getY();
                cir.setCenterX(x);
                cir.setCenterY(y);

                int flag=0;
                for(Circle cc:arcrcl) {
                    if (Math.abs(cc.getCenterX() - x) < 7.7 && Math.abs(cc.getCenterY() - y) < 7.7) {
                        pane.setOnMouseReleased(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent dragEvent) {
                                double hx=dragEvent.getX();
                                double hy=dragEvent.getY();
                                int ff=0;
                                //add edge
                                for(Circle c:arcrcl) {
                                    if (Math.abs(c.getCenterX() - hx) < 7.7 && Math.abs(c.getCenterY() - hy) < 7.7) {
                                        Stage window=new Stage();
                                        window.initModality(Modality.APPLICATION_MODAL);
                                        window.setTitle("Enter weight");
                                        window.setMinWidth(250);
                                        TextField c1 = new TextField();
                                        Button ok=new Button("ok");
                                        ok.setOnAction(new EventHandler<ActionEvent>() {
                                                           @Override
                                                           public void handle(ActionEvent actionEvent) {
                                                               window.close();
                                                           }
                                                       }
                                        );
                                        VBox lay= new VBox();
                                        lay.getChildren().addAll(c1,ok);
                                        window.setScene(new Scene(lay));
                                        window.showAndWait();
                                        System.out.println(map.get(cc).getName()+" "+map.get(c).getName()+" "+String.valueOf(c1.getText()));
                                        gr.addEdge(map.get(cc).getName()+" "+map.get(c).getName()+" "+c1.getText());
                                        gr.addEdge(map.get(c).getName()+" "+map.get(cc).getName()+" "+c1.getText());
                                        ff=1;
                                        Line line=new Line (cc.getCenterX(),cc.getCenterY(),c.getCenterX(),c.getCenterY());
                                        pane.getChildren().add(line);
                                        break;
                                    }

                                }
                              /*  if(ff==0){
                                    Circle nc=new Circle(8);
                                    nc.setCenterX(hx);
                                    nc.setCenterY(hy);
                                    System.out.println(map.get(cc).getName()+" "+String.valueOf(map.get(cc).getX())+" "+String.valueOf(map.get(cc).getY())+" "+map.get(cc).getName()+" "+String.valueOf(hx)+" "+String.valueOf(hy));
                                    gr.modifyVertex(map.get(cc).getName()+" "+String.valueOf(map.get(cc).getX())+" "+String.valueOf(map.get(cc).getY())+" "+map.get(cc).getName()+" "+String.valueOf(hx)+" "+String.valueOf(hy));
                                    pane.getChildren().remove(cc);
                                    pane.getChildren().add(nc);
                                    arcrcl.remove(cc);
                                    arcrcl.add(nc);

                                }*/

                            }
                        });
                  break; }
                }
            });
            pane.setOnMouseClicked(e->{

                double x=e.getX();
                double y=e.getY();
                System.out.println(x + " " + y);
                 Circle cir=new Circle(8);
                cir.setCenterX(x);
                cir.setCenterY(y);
                int flag=0;
                for(Circle c:arcrcl) {
                    if (Math.abs(c.getCenterX()-x)<7.7 && Math.abs(c.getCenterY()-y)<7.7) {
                        flag=1;
                        arcrcl.remove(c);
                        pane.getChildren().remove(c);
                        try{
                        gr.deleteVertex(map.get(c).getName());break;}
                        catch (Exception er){
                            System.out.println("sorry");
                        }


                    }
                }
                if(flag==0){
                    Stage window=new Stage();
                    window.initModality(Modality.APPLICATION_MODAL);
                    window.setTitle("Enter vertex name");
                    window.setMinWidth(250);
                    TextField c1 = new TextField();
                    Button ok=new Button("ok");
                    ok.setOnAction(new EventHandler<ActionEvent>() {
                                       @Override
                                       public void handle(ActionEvent actionEvent) {
                                           window.close();
                                       }
                                   }
                    );
                    VBox lay= new VBox();
                    lay.getChildren().addAll(c1,ok);
                    window.setScene(new Scene(lay));
                    window.showAndWait();
                    arcrcl.add(cir);
                    Vertex vv=new Vertex(c1.getText(),x,y);
                    map.put(cir,vv);
                    mp.put(vv,cir);
                    pane.getChildren().add(cir);
                    gr.addVertex(c1.getText()+" "+String.valueOf(x)+" "+String.valueOf(y));

                    //  e.consume();
                }


            });
            a1.setOnAction(e->{

                String[] pth=gr.printPath(a1.getText()).split(" ");
                double prvx=0;
                double prvy=0;
                Circle cty=new Circle(8);
                for(int i=1;i<pth.length;i++){
                    String nd=pth[i];
                    if(i!=1){
                        Line kl=new Line(prvx,prvy,gr.searchVertex(nd).getX(),gr.searchVertex(nd).getY());
                        kl.setStroke(Color.FIREBRICK);
                        pane.getChildren().add(kl);
                        //TranslateTransition trans = new TranslateTransition()
                    }
                    prvx=gr.searchVertex(nd).getX();
                    prvy=gr.searchVertex(nd).getY();
                    Circle ct=new Circle(8);
                    ct.setCenterX(prvx);
                    ct.setCenterY(prvy);
                    cty=ct;
                    pane.getChildren().add(ct);

                }



                System.out.println(gr.printPath(a1.getText()));
            });


            primaryStage.show();
        }



        public static void main(String[] args) throws Exception {
            // gr.sortGraph();
            //  System.out.println("jkjg");
           /* File ok = new File("C:\\Users\\Abhinandan\\IdeaProjects\\c2p1\\src\\IInput.txt");
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
            }*/
            //gr.printPath("A C");
            launch(args);
        }
    }



