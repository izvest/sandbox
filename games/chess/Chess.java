public class Chess{
    public static void main (String[] args){
        ChessBoard b = new ChessBoard();
        b.draw();
        //b.playChess();
    }
}

class ChessBoard{
    private boolean gameOn;
    ChessPiece[][] board = new ChessPiece[8][8];

    public ChessBoard(){
        boolean wht = false;            //temporary white (for setting the pieces for the right side)
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (i == 1 || i == 6){
                    board[i][j] = new ChessPiece(wht, 's');
                }
                else if (i == 0 || i == 7){
                    if  (j == 0 || j == 7){
                        board[i][j] = new ChessPiece(wht, 't');
                    }
                    else if  (j == 1 || j == 6){
                        board[i][j] = new ChessPiece(wht, 'h');
                    }
                    else if  (j == 2 || j == 5){
                        board[i][j] = new ChessPiece(wht, 'l');
                    }
                }
            }
            if (i == 0 ||i == 7){
                board[i][3] = new ChessPiece(wht, 'q');
                board[i][4] = new ChessPiece(wht, 'k');
            }
            if (i > 2){wht = true;}
        }
    }

    void playChess(){

    }

    void movePiece(String pos){
        
    }

    void draw(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(board[i][j] == null){
                    System.out.print(" - ");
                }
                else{
                    System.out.print(" "+board[i][j].type+" ");
                }
            }
            System.out.println(" ");
        }        
    }
}

class ChessPiece{
    boolean inGame;
    boolean isWhite;
    char type;
    int[] allowedMoves;

    ChessPiece(boolean isWhite, char type){
        this.isWhite = isWhite;
        if (isWhite){
            this.type = Character.toUpperCase(type);
        }
        else{this.type = type;}
    }
}
