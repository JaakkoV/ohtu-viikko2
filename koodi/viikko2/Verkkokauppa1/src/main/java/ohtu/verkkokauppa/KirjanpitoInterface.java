
package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author jaakvirt
 */
public interface KirjanpitoInterface {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
}
