SELECT 
    EMP_NO, 
    EMP_NAME, 
    (CASE
        WHEN AVG_GRADE >= 96 THEN 'S'
        WHEN AVG_GRADE >= 90 THEN 'A'
        WHEN AVG_GRADE >= 80 THEN 'B'
        ELSE 'C'
    END) AS GRADE, 
    (CASE
        WHEN AVG_GRADE >= 96 THEN SAL * 0.2
        WHEN AVG_GRADE >= 90 THEN SAL * 0.15
        WHEN AVG_GRADE >= 80 THEN SAL * 0.1
        ELSE 0
     END) AS BONUS
FROM (
    SELECT 
        em.EMP_NO,
        em.EMP_NAME,
        em.SAL,
        AVG(gr.SCORE) AS AVG_GRADE
    FROM HR_EMPLOYEES em
    JOIN HR_GRADE gr ON em.EMP_NO = gr.EMP_NO
    GROUP BY em.EMP_NO, em.EMP_NAME, em.SAL
    )AS sub
ORDER BY EMP_NO ASC;