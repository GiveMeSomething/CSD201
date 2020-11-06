// 
// Decompiled by Procyon v0.5.36
// 

package graph;

import java.util.ArrayList;

public class GraphRepMatrix {
    public ArrayList<ArrayList<Integer>> graphMatrix; //la ma tran de hien thi cac node da ket noi voi nhau
    public ArrayList<Vertex> identifier; //tap hop cac diem co trong ma tran, dung de xac dinh vi tri trong ma tran

    public GraphRepMatrix() {
        this.graphMatrix = new ArrayList<>();
        this.identifier = new ArrayList<>();
    }

    //sau khi da add xong thi se khoi tao toan bo ma tran bang so khong (khong co connection giua cac Vertex)
    public void initMatrix() {
        for (int i = 0; i < this.graphMatrix.size(); ++i) {
            for (int j = 0; j < this.graphMatrix.size(); ++j) {
                this.graphMatrix.get(i).add(-1);
            }
        }
    }

    //add cac phan tu vao ma tran roi khoi tao ma tran
    public void add(Vertex... vertices) {
        for (Vertex vertex : vertices) {
            this.add(vertex);
        }
        this.initMatrix();
    }

    //them Vertex vao phan identifier va them 1 list moi
    public void add(Vertex vertex) {
        this.identifier.add(vertex);
        this.graphMatrix.add(new ArrayList<>());
    }

    //ket noi Vertex a voi n diem khac
    public void connect(Vertex a, Vertex... others) {
        for (Vertex vertex : others) {
            this.connect(a, vertex);
        }
    }

    //ket noi diem a va b (khong quan trong gia tri duong di)
    public void connect(Vertex a, Vertex b) {
        connect(a, b, 1);
    }

    //ket noi 2 diem a va b nhung co gia tri duong di
    public void connect(Vertex a, Vertex b, int value){
        int firstPos = -1;
        int secondPos = -1;
        //tim vi tri cua 2 diem trong tham so
        for (int i = 0; i < identifier.size(); ++i) {
            if (firstPos == -1 && identifier.get(i) == a) {
                firstPos = i;
            }
            if (secondPos == -1 && identifier.get(i) == b) {
                secondPos = i;
            }
            if (firstPos != -1 && secondPos != -1) {
                break;
            }
        }
        //neu khong tim thay
        if (firstPos == -1 || secondPos == -1) {
            System.out.println("Can't connect");
            return;
        }
        //set vi tri da tim thay bang 1
        //vi tri duoc xac dinh qua identifier
        this.graphMatrix.get(firstPos).set(secondPos, value);
        this.graphMatrix.get(secondPos).set(firstPos, value);
    }

    //in ra ma tran (duyet qua cac phan tu va in ra)
    public void display() {
        System.out.println();
        System.out.print("\t");
        for (int i = 0; i < this.identifier.size(); ++i) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < this.identifier.size(); ++i) {
            System.out.print(i + "\t");
            for (int j = 0; j < this.identifier.size(); ++j) {
                System.out.print(this.graphMatrix.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
