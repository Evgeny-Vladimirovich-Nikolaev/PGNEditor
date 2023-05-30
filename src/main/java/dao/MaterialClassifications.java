package dao;

public enum MaterialClassifications {

    PAWNS("Одни пешки"),
    ONE_KNIGHT("Один конь"),
    TWO_KNIGHTS_SAME_SIDE("Два коня одной стороны"),
    KNIGHT_AGAINST_KNIGHT(""),
    THREE_OR_MORE_KNIGHTS(""),
    ONE_BISHOP(""),
    BISHOP_AGAINST_BISHOP_SAME_COLORED(""),
    BISHOP_AGAINST_BISHOP_OPPOSITE_COLORED(""),
    SEVERAL_BISHOPS(""),
    BISHOP_AGAINST_KNIGHT(""),
    BISHOPS_VS_KNIGHTS_AGAINST_PAWNS(""),
    BISHOPS_KNIGHTS_VARIATIONS(""),
    ONE_ROOK(""),
    ROOK_AGAINST_ROOK(""),
    SEVERAL_ROOKS(""),
    ROOK_AGAINST_KNIGHT(""),
    ROOK_VS_KNIGHT_AGAINST_PAWNS(""),
    ROOKS_KNIGHTS_VARIATIONS(""),
    ROOK_AGAINST_BISHOP(""),
    ROOK_VS_BISHOP_AGAINST_PAWNS(""),
    ROOKS_BISHOPS_VARIATIONS(""),
    ROOK_BISHOP_KNIGHT_VARIATIONS_3_PIECES(""),
    ROOKS_BISHOPS_KNIGHTS_VARIATIONS_4_PIECES(""),
    ROOKS_BISHOPS_KNIGHTS_VARIATIONS_5_OR_MORE_PIECES("");

    private String category;
    MaterialClassifications(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
