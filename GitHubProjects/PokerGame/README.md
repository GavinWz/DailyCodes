# PokerGame

算法思想：

    1. 创建玩家和人机各自的随机数数组，用于生成手牌，通过创建随机数函数向双方随机数数组中生成等量随机数作为手牌。
    2. 创建双方的二叉排序树，用于存储并排序各自生成的手牌。
    3. 创建双方的手牌链表，并中序遍历各自的二叉排序树，将每次遍历到的手牌用尾插法插入链表，得到降序的手牌链表
    4. 程序提示玩家先出牌。
    5. 人机会在1秒之后做出反应，有牌大的过则出牌，否则不出，玩家继续出牌。
    6. 若人机大的过且出牌，则判断用户是否大的过，若是，则用户出牌，若用户要不起，则提示没有牌可大的过
    7. 步骤5和6循环执行，直至一方出牌完毕，程序提示胜负结果
