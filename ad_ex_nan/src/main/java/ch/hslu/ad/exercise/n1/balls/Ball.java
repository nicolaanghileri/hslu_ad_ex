/*
 * Copyright 2025 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.exercise.n1.balls;

/**
 * Description of class Ball
 */
public final class Ball implements Runnable {

    private final Circle circle;
    private final int size;
    private final int offset;
    private final int fallSpeed;

    /**
     * Erzeugt einen Ball mit gegebenen Parametern Grösse, Position und Farbe.
     *
     * @param size Grösse des Balls.
     * @param xPos X-Position des Balls.
     * @param yPos Y-Position des Balls.
     * @param color Farbe des Balls.
     */
    public Ball(final int size, final int xPos, final int yPos, String color) {
        this.size = size;
        this.circle = new Circle(size, xPos, yPos, color);
        this.circle.makeVisible();

        this.offset = (int) (Math.random() * 7) - 3;
        this.fallSpeed = (int) (Math.random() * 40) + 10;
    }

    @Override
    public void run() {
        while(this.circle.getY() < 400 - this.size){
            this.circle.moveDown();
            this.circle.moveHorizontal(this.offset);
            try {
                Thread.sleep(fallSpeed);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        this.circle.makeInvisible();
    }
}
