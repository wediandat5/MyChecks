package edu.wsu.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * Counts syntactic semicolon tokens in each Java source file.
 * Semicolons inside comments and string literals are excluded.
 */
public class SemiColonCheck extends AbstractCheck {

    private int count;

    @Override
    public int[] getDefaultTokens() {
        return new int[] {TokenTypes.SEMI};
    }

    @Override
    public int[] getAcceptableTokens() {
        return getDefaultTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return getDefaultTokens();
    }

    @Override
    public void beginTree(DetailAST rootAST) {
        count = 0;
    }

    @Override
    public void visitToken(DetailAST ast) {
        count++;
    }

    @Override
    public void finishTree(DetailAST rootAST) {
        log(1, "semicolon.count", count);
    }
}