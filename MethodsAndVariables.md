Grid.java

Variables
- moves: boolean[]
- playerMoves: boolean[]
- computerMoves: boolean[]
- grid: String[]
- winSet: int[][]
- roundNumber: int

Methods
+ Grid()
+ initGrid(): void
+ drawGrid(): void
+ displayHelp(): void

+ incRoundNumber(int i): void
+ updateGrid(String token, int i): void
+ updateMoves(int i): void
+ updatePlayerMoves(int i): void
+ updateComputerMoves(int i): void

+ getRoundNumber(int i): int
+ isPlayed(int i): boolean
+ isPlayedByPlayer(int i): boolean
+ isPlayedByComp(int i): boolean

+ isFinished(): boolean
+ checkSquareAvail(int i): boolean 


Computer.java

Variables


Methods
