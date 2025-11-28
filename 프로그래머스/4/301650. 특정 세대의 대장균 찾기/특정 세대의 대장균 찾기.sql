-- 3세대 대장균의 ID 출력
-- 컬럼 추가해서 몇 세대인지 확인
WITH RECURSIVE family AS (
    SELECT ID, PARENT_ID, 1 AS depth
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT e.ID, e.PARENT_ID, depth+1 AS depth
    FROM ECOLI_DATA e
    INNER JOIN family f ON f.ID=e.PARENT_ID
)

SELECT ID
FROM family
WHERE depth=3
ORDER BY ID ASC;