-- 投票項目
CREATE TABLE IF NOT EXISTS esunbank.voting_items (
    ID INT PRIMARY KEY,
    Voting_ItemNo INT NOT NULL UNIQUE,
    Voting_ItemName VARCHAR(255) NOT NULL
);

-- 投票紀錄
CREATE TABLE IF NOT EXISTS esunbank.voting_history (
    ID INT PRIMARY KEY,
    Voter VARCHAR(255) NOT NULL,
    Voting_ItemNo INT NOT NULL,
);

-- 插入基本資料
INSERT INTO esunbank.voting_items (ID,Voting_ItemNo, Voting_ItemName) VALUES
(1,1, '電腦'),
(2,2, '滑鼠'),
(3,3, '鍵盤');

INSERT INTO esunbank.voting_history (ID,Voter, Voting_ItemNo) VALUES 
(1,'Leo', 1),
(2,'Sandy', 1),
(3,'Sandy', 2),
(4,'Randy', 2),
(5,'RSY', 2);

-- 建立計算累積票數的 Stored Procedure

CREATE PROCEDURE esunbank.GetVotingCounts()
BEGIN
    SELECT 
        vi.Voting_ItemNo, 
        vi.Voting_ItemName, 
        COUNT(vh.ID) AS VoteCount
    FROM 
        esunbank.voting_items vi
    LEFT JOIN 
        esunbank.voting_history vh 
    ON 
        vi.Voting_ItemNo = vh.Voting_ItemNo
    GROUP BY 
        vi.Voting_ItemNo, vi.Voting_ItemName;
END 


