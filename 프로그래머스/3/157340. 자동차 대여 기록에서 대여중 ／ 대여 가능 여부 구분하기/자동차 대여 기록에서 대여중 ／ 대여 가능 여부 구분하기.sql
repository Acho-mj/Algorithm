SELECT 
    CAR_ID, 
    -- 2022-10-16이 DATE 사이에 존재하는지 확인하고 -> 존재하면 대여중
    IF(CAR_ID IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16'
        -- WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
    ), '대여중', '대여 가능') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;