package com.edwinnyawoli.qrcodegenerator;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

/**
 *
 */

public class QRCodeBitmapGenerator {
    private static final int WIDTH = 500;

    /**
     * Generates a QRCode bitmap for the specified string.
     *
     * @param str The string to encode.
     * @return A QRCode bitmap or null if an error occurred.
     */
    public Bitmap encodeAsBitmap(String str) {
        Bitmap bitmap = null;
        BitMatrix result = null;

        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, WIDTH, WIDTH, null);
            int w = result.getWidth();
            int h = result.getHeight();
            int[] pixels = new int[w * h];
            for (int y = 0; y < h; y++) {
                int offset = y * w;
                for (int x = 0; x < w; x++) {
                    pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
                }
            }
            bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, WIDTH, 0, 0, w, h);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
