import java.util.Arrays;

public class App {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        //Creamos la matriz adyacente con las aristas obtenidas como parametro.
        int[][] matAdy = new int[n][n]; //Sergio Lara
        
        for(int i=0; i<n; i++) { //Sergio Lara
            Arrays.fill(matAdy[i], Integer.MAX_VALUE/2);//Sergio Lara           //Rellenamos los datos de la matriz.
            matAdy[i][i] = 0;  //Isaac Flores    //Rellena la diagonal de 0 por que la distancia de una a si misma es cero.
        }
        
        for(int[] edge: edges) { //Isaac Flores
            matAdy[edge[0]][edge[1]] = Math.min(matAdy[edge[0]][edge[1]], edge[2]); //Isaac Flores   //Busca el camino minimo para ir de una ciudad a otra
            matAdy[edge[1]][edge[0]] = Math.min(matAdy[edge[1]][edge[0]], edge[2]); //Paul Aldea                 //asociando el camino minimo a la arista
        }
        
        //Compara si el camino es mas corto yendo recto o tomando un desvio de una ciudad a otra.
        for (int k=0; k < n; k++) {//Paul Aldea
            for (int i=0; i < n; i++) { //Sergio Lara
                for (int j=0; j < n; j++) {
                    if (matAdy[i][j] > matAdy[i][k] + matAdy[k][j]) {//Paul Aldea
                        matAdy[i][j] = matAdy[i][k] + matAdy[k][j];//Paul Aldea
                    }
                }
            }
        }
        
        // Busca la ciudad con menos accesibilidad de llegar a otras dado el umbral de ciudades.
        int resultado = -1; //Felipe Toro
        int minimoAlcanzable = Integer.MAX_VALUE;//Felipe Toro
        
        for(int i=0; i<n; i++) {//Felipe Toro
            int alcanzable = 0; //Rene Yañez
            for(int j=0; j<n; j++) { //Rene Yañez
                if(matAdy[i][j] <= distanceThreshold){//Rene Yañez
                    alcanzable++;//Cristian Pinilla
                }
            }
            if(minimoAlcanzable >= alcanzable){ //Cristian Pinilla
                minimoAlcanzable = alcanzable; //Cristian Pinilla
                resultado = i;
            }
        }
        return resultado;
    }
}
