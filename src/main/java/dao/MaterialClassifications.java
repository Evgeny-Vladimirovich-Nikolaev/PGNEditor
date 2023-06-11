package dao;

public enum MaterialClassifications {

    P("Одни пешки", 1),
    ONE_N("Один конь", 2),
    TWO_N_SAME_SIDE("Два коня одной стороны", 3),
    N_VS_N("Конь против коня", 4),
    THREE_OR_MORE_N("Три (и более) коня", 5),
    ONE_B("Один слон", 6),
    TWO_B_SAME_SIDE("Два слона одной стороны", 7),

    B_VS_B_SAME_COLORED("Слон против слона (одноцветные)", 8),
    B_VS_B_OPPOSITE_COLORED("Слон против слона (разноцветные)", 9),
    THREE_OR_MORE_B("Три (и более) слонов", 10),
    B_VS_N("Слон против коня", 11),
    BN_VS_P("Слон (слоны) и конь (кони) одной стороны против пешек", 12),
    BN_VARIATIONS("Вариации слонов и коней", 13),
    ONE_R("Одна ладья", 14),
    R_VS_R("Ладья против ладьи", 15),
    TWO_R_SAME_SIDE("Две ладьи одной стороны", 16),

    THREE_OR_MORE_R("Три (и более) ладей", 17),
    R_VS_N("Ладья против коня", 18),
    RN_VS_P("Ладья и конь одной стороны против пешек", 19),
    RN_VARIATIONS("Вариации ладей и коней", 20),
    R_VS_B("Ладья против слона", 21),
    RB_VS_P("Ладья и слон против пешек", 22),
    RB_VARIATIONS("Вариации ладей и слонов", 23),
    RBN_VARIATIONS_3("Вариации ладьи, слона и коня (три фигуры)", 24),
    RBN_VARIATIONS_4("Вариации ладей,слонов и коней (четыре фигуры)", 25),
    RBN_VARIATIONS_5_OR_MORE("Вариации ладей,слонов и коней (пять и более фигур)", 26),
    Q_VS_P("Ферзь против пешек", 27),
    Q_VS_Q("Ферзь против ферзя", 28),
    QN_VARIATIONS("Вариации ферзей и коней", 29),
    QB_VARIATIONS("Вариации ферзей и слонов", 30),
    QBN_VARIATIONS_3("Вариации ферзя, слона и коня (три фигуры)", 31),
    QBN_VARIATIONS_4("Вариации ферзей, слонов и коней (четыре фигуры)", 32),
    QBN_VARIATIONS_5_OR_MORE_PIECES("Вариации ферзей, слонов и коней (пять и более фигур)", 33),
    QR_VARIATIONS("Вариации ферзей и ладей", 34),
    QRN_VARIATIONS("Вариации ферзей, ладей и коней", 35),
    QRB_VARIATIONS("Вариации ферзей, ладей и слонов", 36),
    QRBN_VARIATIONS_4("Вариации ферзя, ладьи, слона и коня (четыре фигуры)", 37),
    QRBN_VARIATIONS_5("Вариации ферзей, ладей, слонов и коней (пять фигур)", 38),
    QRBN_VARIATIONS_6_0R_M0RE("Вариации ферзей, ладей, слонов и коней (шесть и более фигур)", 39);

    private String category;
    private int index;
    MaterialClassifications(String category, int index) {
        this.category = category;
        this.index = index;
    }

    public String getCategory() {
        return category;
    }
    public int getIndex() {
        return index;
    }
}
