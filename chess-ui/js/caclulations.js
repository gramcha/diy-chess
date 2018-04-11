/**
 * Created by gramachandran on 15/01/18.
 */
// exports a function declared earlier


const calculateBoardState = function (game) {
  let baseX = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'];
  let baseY = ['1', '2', '3', '4', '5', '6', '7', '8'];
  const boardState = {
    "fullmoves": movecount,
    "white_win": "True",
    "pawn_diff": 0,
    "rook_diff": 0,
    "knight_diff": 0,
    "bishop_diff": 0,
    "queen_diff": 0
  };
  let wpawn = 0;
  let bpawn = 0;
  let wrook = 0;
  let brook = 0;
  let wknight = 0;
  let bknight = 0;
  let wbishop = 0;
  let bbishop = 0;
  let wqueen = 0;
  let bqueen = 0;

  for (var i = 0; i < 8; i++) {
    for (var j = 0; j < 8; j++) {
      const pos = baseX[i] + baseY[j];
      const value = game.get(pos);
      // console.log("pos " + pos + " - ", value);
      if (value) {
        switch (value.color) {
          case 'b':
            switch (value.type) {
              case 'p':
                bpawn++;
                break;
              case 'r':
                brook++;
                break;
              case 'n':
                bknight++;
                break;
              case 'b':
                bbishop++
                break;
              case 'q':
                bqueen++;
                break;
            }
            break;
          case 'w':
            switch (value.type) {
              case 'p':
                wpawn++;
                break;
              case 'r':
                wrook++;
                break;
              case 'n':
                wknight++;
                break;
              case 'b':
                wbishop++
                break;
              case 'q':
                wqueen++;
                break;
            }
            break;
        }
      }

    }
  }
  boardState.pawn_diff = wpawn - bpawn;
  boardState.rook_diff = wrook - brook;
  boardState.knight_diff = wknight - bknight;
  boardState.bishop_diff = wbishop - bbishop;
  boardState.queen_diff = wqueen - bqueen;
  return boardState;
}

const calculateBestMove = function (game) {
  let possibleMoves = game.moves();
  // game over
  let movesAndStates = [];
  if (possibleMoves.length === 0) return;
  possibleMoves.forEach(function (move, index) {
    console.log("move " + (index + 1) + " " + move);
    game.move(move);
    state = calculateBoardState(game);
    state['move'] = move;
    movesAndStates.push(state);
    game.undo();
  });
  //post to chess backennd service to get the win status of each move.
  // $.ajax({
  //   type: 'POST',
  //   url: 'http://127.0.0.1:8080/moves',
  //   data: JSON.stringify(movesAndStates),
  //   Accept: "application/json",
  //   // contentType: "application/json;",
  //   crossDomain: true,
  //   // traditional: true,
  //   success: function (data) {
  //     console.log("data from service ",data);
  //   },
  //   error: function( jqXhr, textStatus, errorThrown ){
  //     console.log( errorThrown );
  //   }
  // });
  $.ajax({
    url: "http://127.0.0.1:8080/moves", data: JSON.stringify(movesAndStates), type: 'POST', contentType: 'application/json',
  }).done((data)=>{
    console.log(data);
  }).fail((response, status) => {
//            handle error response
    console.log(response);
    console.log(status);
  });
  return movesAndStates;
}

const exportFunctions = {calculateBoardState, calculateBestMove};
window.calc = exportFunctions;
