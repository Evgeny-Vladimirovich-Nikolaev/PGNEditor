package dao;

public enum MaterialClassifications {

    P("Одни пешки"),
    ONE_N("Один конь"),
    TWO_N_SAME_SIDE("Два коня одной стороны"),
    N_VS_N("Конь против коня"),
    THREE_OR_MORE_N("Три (и более) коня"),
    ONE_B("Один слон"),
    B_VS_B_SAME_COLORED("Слон против слона (одноцветные)"),
    B_VS_B_OPPOSITE_COLORED("Слон против слона (разноцветные)"),
    SEVERAL_B("Несколько слонов"),
    B_VS_N("Слон против коня"),
    BN_VS_P("Слон (слоны) и конь (кони) одной стороны против пешек"),
    BN_VARIATIONS("Вариации слонов и коней"),
    ONE_R("Одна ладья"),
    R_VS_R("Ладья против ладьи"),
    SEVERAL_R("Несколько ладей"),
    R_VS_N("Ладья против коня"),
    RN_VS_P("Ладья и конь одной стороны против пешек"),
    RN_VARIATIONS("Вариации ладей и коней"),
    R_VS_B("Ладья против слона"),
    RB_VS_P("Ладья и слон против пешек"),
    RB_VARIATIONS("Вариации ладей и слонов"),
    RBN_VARIATIONS_3("Вариации ладьи, слона и коня (три фигуры)"),
    RBN_VARIATIONS_4("Вариации ладей,слонов и коней (четыре фигуры)"),
    RBN_VARIATIONS_5_OR_MORE("Вариации ладей,слонов и коней (пять и более фигур)"),
    Q_VS_P("Ферзь против пешек"),
    Q_VS_Q("Ферзь против ферзя"),
    QN_VARIATIONS("Вариации ферзей и коней"),
    QB_VARIATIONS("Вариации ферзей и слонов"),
    QBN_VARIATIONS_3("Вариации ферзя, слона и коня (три фигуры)"),
    QBN_VARIATIONS_4("Вариации ферзей, слонов и коней (четыре фигуры)"),
    QBN_VARIATIONS_5_OR_MORE_PIECES("Вариации ферзей, слонов и коней (пять и более фигур)"),
    QR_VARIATIONS("Вариации ферзей и ладей"),
    QRN_VARIATIONS("Вариации ферзей, ладей и коней"),
    QRB_VARIATIONS("Вариации ферзей, ладей и слонов"),
    QRBN_VARIATIONS_4("Вариации ферзя, ладьи, слона и коня (четыре фигуры)"),
    QRBN_VARIATIONS_5("Вариации ферзей, ладей, слонов и коней (пять фигур)"),
    QRBN_VARIATIONS_6_0R_M0RE("Вариации ферзей, ладей, слонов и коней (шесть и более фигур)");

    private String category;
    MaterialClassifications(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
