package e2;

public class SocialDistance {
    public static char[][] seatingPeople(char[][] layout) {
        int check = 0;
        if(layout==null || layout.length==0){ //Si la matriz es nula o no tiene elementos
            throw new IllegalArgumentException("Initial layout is invalid.");
        }
        for (int i = 0; i < layout.length; i++) { //Comprueba que todas las filas tengas el mismo tamaño
            if (layout[0].length != layout[i].length) {
                check++;
                break;
            }
            for (int j = 0; j < layout[i].length; j++) { //Comprueba que los caracteres que se le pasan son A o .
                if (layout[i][j] != 'A' && layout[i][j] != '.') {
                    check++;
                    break;
                }
            }
        }
        if (check > 0) {
            throw new IllegalArgumentException("Initial layout is invalid.");
        }
        //Creamos matriz auxiliar y copiamos los valores
        char[][] layoutCopy= new char[layout.length][layout[layout.length-1].length];

        for (int i = 0; i < layout.length; i++) {
            System.arraycopy(layout[i], 0, layoutCopy[i], 0, layout[i].length);
        }
        //Empieza el algoritmo
        int personas;
        int end;
        do{
            end=0;
            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[i].length; j++) {
                    personas=SocialDistance.counter(layout, i, j);
                    if(personas==0 && layout[i][j]=='A'){
                        layoutCopy[i][j]='#';
                    } else{
                        layoutCopy[i][j]=layout[i][j];
                    }
                }
            }
            for (int i = 0; i < layout.length; i++) {
                System.arraycopy(layoutCopy[i], 0, layout[i], 0, layout[i].length);
            }
            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[i].length; j++) {
                    personas=SocialDistance.counter(layout, i, j);
                    if(layout[i][j]=='#' && personas>3){
                        layoutCopy[i][j]='A';
                        end++;
                    } else{
                        layoutCopy[i][j]=layout[i][j];
                    }
                }
            }
            for (int i = 0; i < layout.length; i++) {
                System.arraycopy(layoutCopy[i], 0, layout[i], 0, layout[i].length);
            }

        } while(end!=0);
        return layout;
    }
    //Contador de personas cercanas
    public static int counter(char[][] layout, int i, int j){
        int cnt=0;
            //Caso general
            for (int a = i-1; a <= i+1; a++) {
                for (int b = j-1; b <= j+1; b++) {
                    if(a!=-1&&a!= layout.length && b!=-1 && b!=layout[i].length){
                        if(a!=i || b!=j) {
                            if(layout[a][b]=='#'){
                                cnt++;
                            }
                        }
                    }
                }
            }
        return cnt;
    }
}
