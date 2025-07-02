-- 거래상태(STATUS)
-- SALE : 판매중
-- RESERVED : 예약중
-- DONE : 거래완료
SELECT 
    BOARD_ID, 
    WRITER_ID, 
    TITLE, 
    PRICE, 
    (SELECT 
     CASE 
        WHEN STATUS = 'SALE'
        THEN "판매중"
        WHEN STATUS = 'RESERVED'
        THEN "예약중"
        ELSE "거래완료"
     END
    ) AS STATUS
FROM USED_GOODS_BOARD 
WHERE DATE_FORMAT(CREATED_DATE, "%Y-%m-%d") = '2022-10-05'
ORDER BY BOARD_ID DESC;